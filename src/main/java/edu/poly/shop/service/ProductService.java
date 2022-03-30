package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import edu.poly.shop.domain.Product;

public interface ProductService {

	/**
	 * @param <S>
	 * @param example
	 * @param sort
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll(org.springframework.data.domain.Example, org.springframework.data.domain.Sort)
	 */
	<S extends Product> List<S> findAll(Example<S> example, Sort sort);

	/**
	 * @param <S>
	 * @param example
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll(org.springframework.data.domain.Example)
	 */
	<S extends Product> List<S> findAll(Example<S> example);

	/**
	 * @param id
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#getById(java.lang.Object)
	 */
	Product getById(Long id);

	/**
	 * 
	 * @see org.springframework.data.repository.CrudRepository#deleteAll()
	 */
	void deleteAll();

	/**
	 * @param entities
	 * @see org.springframework.data.repository.CrudRepository#deleteAll(java.lang.Iterable)
	 */
	void deleteAll(Iterable<? extends Product> entities);

	/**
	 * @param ids
	 * @see org.springframework.data.repository.CrudRepository#deleteAllById(java.lang.Iterable)
	 */
	void deleteAllById(Iterable<? extends Long> ids);

	/**
	 * @param <S>
	 * @param <R>
	 * @param example
	 * @param queryFunction
	 * @return
	 * @see org.springframework.data.repository.query.QueryByExampleExecutor#findBy(org.springframework.data.domain.Example, java.util.function.Function)
	 */
	<S extends Product, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	/**
	 * @param entity
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Object)
	 */
	void delete(Product entity);

	/**
	 * @param id
	 * @see org.springframework.data.repository.CrudRepository#deleteById(java.lang.Object)
	 */
	void deleteById(Long id);

	/**
	 * @param <S>
	 * @param example
	 * @return
	 * @see org.springframework.data.repository.query.QueryByExampleExecutor#exists(org.springframework.data.domain.Example)
	 */
	<S extends Product> boolean exists(Example<S> example);

	/**
	 * @param entities
	 * @see org.springframework.data.jpa.repository.JpaRepository#deleteAllInBatch(java.lang.Iterable)
	 */
	void deleteAllInBatch(Iterable<Product> entities);

	/**
	 * @param <S>
	 * @param example
	 * @param pageable
	 * @return
	 * @see org.springframework.data.repository.query.QueryByExampleExecutor#findAll(org.springframework.data.domain.Example, org.springframework.data.domain.Pageable)
	 */
	<S extends Product> Page<S> findAll(Example<S> example, Pageable pageable);

	/**
	 * @param <S>
	 * @param entities
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#saveAll(java.lang.Iterable)
	 */
	<S extends Product> List<S> saveAll(Iterable<S> entities);

	/**
	 * @param id
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	Optional<Product> findById(Long id);

	/**
	 * @param ids
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAllById(java.lang.Iterable)
	 */
	List<Product> findAllById(Iterable<Long> ids);

	/**
	 * @param sort
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll(org.springframework.data.domain.Sort)
	 */
	List<Product> findAll(Sort sort);

	/**
	 * @param pageable
	 * @return
	 * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Pageable)
	 */
	Page<Product> findAll(Pageable pageable);

	/**
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll()
	 */
	List<Product> findAll();

	/**
	 * @param <S>
	 * @param example
	 * @return
	 * @see org.springframework.data.repository.query.QueryByExampleExecutor#findOne(org.springframework.data.domain.Example)
	 */
	<S extends Product> Optional<S> findOne(Example<S> example);

	/**
	 * @param <S>
	 * @param entity
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	<S extends Product> S save(S entity);

}
