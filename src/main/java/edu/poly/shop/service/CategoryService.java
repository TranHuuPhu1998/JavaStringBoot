package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.Category;
@Service
public interface CategoryService {

	/**
	 * @param id
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	Optional<Category> findById(Long id);

	/**
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll()
	 */
	List<Category> findAll();

	/**
	 * @param <S>
	 * @param entity
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	<S extends Category> S save(S entity);

	/**
	 * @param name
	 * @return
	 * @see edu.poly.shop.reponsitory.CategoryRepository#findByNameContaining(java.lang.String)
	 */
	List<Category> findByNameContaining(String name);

	/**
	 * @param id
	 * @see org.springframework.data.repository.CrudRepository#deleteById(java.lang.Object)
	 */
	void deleteById(Long id);

	/**
	 * @param name
	 * @param pageable
	 * @return 
	 * @see edu.poly.shop.reponsitory.CategoryRepository#findByNameContaining(java.lang.String, org.springframework.data.domain.Pageable)
	 */
	Page<Category> findByNameContaining(String name, Pageable pageable);

	/**
	 * @param pageable
	 * @return
	 * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Pageable)
	 */
	Page<Category> findAll(Pageable pageable);


}
