package edu.poly.shop.controller.admin;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.shop.domain.Product;
import edu.poly.shop.model.CategoryDto;
import edu.poly.shop.model.ProductDto;
import edu.poly.shop.service.CategoryService;
import edu.poly.shop.service.ProductService;

@Controller 
@RequestMapping("admin/products")
public class ProductController {
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;

	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("product" , new ProductDto());
		return "admin/products/addOrEdit";
	}

	@ModelAttribute("categories")
	public List<CategoryDto> getCategories(){
		List <CategoryDto> categories = categoryService.findAll().stream().map(item ->{
			CategoryDto dto = new CategoryDto();
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).toList();
		return categories;
	}
	
	@GetMapping("edit/{productId}")
	public ModelAndView edit(ModelMap model, @PathVariable("productId") Long productId) {
		Optional<Product> opt = productService.findById(productId);

		ProductDto dto = new ProductDto(); 
		if(opt.isPresent()) {
			Product entity = opt.get();
			// dto = entity
			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);
			
			model.addAttribute("product", dto);
			// truyền dto cho view
			return new ModelAndView("admin/products/addOrEdit",model);
		}
		
		model.addAttribute("message" , "Products is not existed");
		return new ModelAndView("forward:/admin/products",model);
	}

	@GetMapping("delete/{productId}")
	public ModelAndView delete(ModelMap model,@PathVariable("productId") Long productId) {
		categoryService.deleteById(productId);
		model.addAttribute("message","Category is deleted");
		return new ModelAndView("forward:/admin/categories/search", model);
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,
		@Valid @ModelAttribute("product") ProductDto dto,
		BindingResult result) {

		if(result.hasErrors()) {
			return new ModelAndView("admin/categories/addOrEdit");
		}
		
		Product entity = new Product();
		// use function copyProperties for copy dto to entiry 
		// entity = dto
		BeanUtils.copyProperties(dto, entity);
		
		// save info entity for db
		productService.save(entity);
		
		model.addAttribute("message" , "Product is saved!");
		
		return new ModelAndView("redirect:/admin/products", model);
	}
	
	@GetMapping("")
	public String list(ModelMap model) {
		List<Product> list =  productService.findAll();
		
		model.addAttribute("categories" , list);
		
		return "admin/categories/list";
	}
	
	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name="name", required=false) String name) {
		List<Product> list = null;
		if(StringUtils.hasText(name)) {
			// list = categoryService.findByNameContaining(name);
		}else {
			list = productService.findAll();
		}
		
		model.addAttribute("categories", list);
		
		return "admin/categories/search";
	}
	
	@GetMapping("searchpaginated")
	public String search(ModelMap model, 
			@RequestParam(name="name", required=false) String name,
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size ) {
		
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);

		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("name"));
		
		Page<Product> resultPage = null;
		
		if(StringUtils.hasText(name)) {
			// resultPage = categoryService.findByNameContaining(name,pageable);
			model.addAttribute("name",name);
		}else {
			resultPage = productService.findAll(pageable);
		}
		
		int totalPages = resultPage.getTotalPages();
		
		if(totalPages > 0) {
			int start = Math.max(1, currentPage - 2);
			int end = Math.min(currentPage + 2 , totalPages);
			if(totalPages > 5) {
				if(end == totalPages) start = end -5;
				else if(start == 1) end = start + 5;
			}
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
			
			model.addAttribute("pageNumbers", pageNumbers);
		}

		model.addAttribute("categoryPage", resultPage);
		
		return "admin/categories/searchpaginated";
	}
	
}
