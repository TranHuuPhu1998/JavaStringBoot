package edu.poly.shop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.Category;
import edu.poly.shop.reponsitory.CategoryRepository;
import edu.poly.shop.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	CategoryRepository categoryReponsitory;


	public CategoryServiceImpl(CategoryRepository categoryReponsitory) {
		this.categoryReponsitory = categoryReponsitory;
	}


	/**
	 * @param name
	 * @return
	 * @see edu.poly.shop.reponsitory.CategoryRepository#findByNameContaining(java.lang.String)
	 */
	@Override
	public List<Category> findByNameContaining(String name) {
		return categoryReponsitory.findByNameContaining(name);
	}


	/**
	 * @param <S>
	 * @param entity
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	@Override
	public <S extends Category> S save(S entity) {
		return categoryReponsitory.save(entity);
	}


	/**
	 * @param pageable
	 * @return
	 * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryReponsitory.findAll(pageable);
	}


	/**
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll()
	 */
	@Override
	public List<Category> findAll() {
		return categoryReponsitory.findAll();
	}


	/**
	 * @param id
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@Override
	public Optional<Category> findById(Long id) {
		return categoryReponsitory.findById(id);
	}


	/**
	 * @param id
	 * @see org.springframework.data.repository.CrudRepository#deleteById(java.lang.Object)
	 */
	@Override
	public void deleteById(Long id) {
		categoryReponsitory.deleteById(id);
	}


	/**
	 * @param name
	 * @param pageable
	 * @return
	 * @see edu.poly.shop.reponsitory.CategoryRepository#findByNameContaining(java.lang.String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Category> findByNameContaining(String name, Pageable pageable) {
		return categoryReponsitory.findByNameContaining(name, pageable);
	}
	
}
