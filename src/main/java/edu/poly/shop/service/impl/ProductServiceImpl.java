package edu.poly.shop.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.Product;
import edu.poly.shop.reponsitory.ProductReponsitory;
import edu.poly.shop.service.ProductService;

@Service   
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductReponsitory productReponsitory;

	/**
	 * @param <S>
	 * @param entity
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	@Override
	public <S extends Product> S save(S entity) {
		return productReponsitory.save(entity);
	}

	/**
	 * @param <S>
	 * @param example
	 * @return
	 * @see org.springframework.data.repository.query.QueryByExampleExecutor#findOne(org.springframework.data.domain.Example)
	 */
	@Override
	public <S extends Product> Optional<S> findOne(Example<S> example) {
		return productReponsitory.findOne(example);
	}

	/**
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll()
	 */
	@Override
	public List<Product> findAll() {
		return productReponsitory.findAll();
	}

	/**
	 * @param pageable
	 * @return
	 * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productReponsitory.findAll(pageable);
	}

	/**
	 * @param sort
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll(org.springframework.data.domain.Sort)
	 */
	@Override
	public List<Product> findAll(Sort sort) {
		return productReponsitory.findAll(sort);
	}

	/**
	 * @param ids
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAllById(java.lang.Iterable)
	 */
	@Override
	public List<Product> findAllById(Iterable<Long> ids) {
		return productReponsitory.findAllById(ids);
	}

	/**
	 * @param id
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@Override
	public Optional<Product> findById(Long id) {
		return productReponsitory.findById(id);
	}

	/**
	 * @param <S>
	 * @param entities
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#saveAll(java.lang.Iterable)
	 */
	@Override
	public <S extends Product> List<S> saveAll(Iterable<S> entities) {
		return productReponsitory.saveAll(entities);
	}

	/**
	 * @param <S>
	 * @param example
	 * @param pageable
	 * @return
	 * @see org.springframework.data.repository.query.QueryByExampleExecutor#findAll(org.springframework.data.domain.Example, org.springframework.data.domain.Pageable)
	 */
	@Override
	public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
		return productReponsitory.findAll(example, pageable);
	}

	/**
	 * @param entities
	 * @see org.springframework.data.jpa.repository.JpaRepository#deleteAllInBatch(java.lang.Iterable)
	 */
	@Override
	public void deleteAllInBatch(Iterable<Product> entities) {
		productReponsitory.deleteAllInBatch(entities);
	}

	/**
	 * @param <S>
	 * @param example
	 * @return
	 * @see org.springframework.data.repository.query.QueryByExampleExecutor#exists(org.springframework.data.domain.Example)
	 */
	@Override
	public <S extends Product> boolean exists(Example<S> example) {
		return productReponsitory.exists(example);
	}

	/**
	 * @param id
	 * @see org.springframework.data.repository.CrudRepository#deleteById(java.lang.Object)
	 */
	@Override
	public void deleteById(Long id) {
		productReponsitory.deleteById(id);
	}

	/**
	 * @param entity
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Product entity) {
		productReponsitory.delete(entity);
	}

	/**
	 * @param <S>
	 * @param <R>
	 * @param example
	 * @param queryFunction
	 * @return
	 * @see org.springframework.data.repository.query.QueryByExampleExecutor#findBy(org.springframework.data.domain.Example, java.util.function.Function)
	 */
	@Override
	public <S extends Product, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return productReponsitory.findBy(example, queryFunction);
	}

	/**
	 * @param ids
	 * @see org.springframework.data.repository.CrudRepository#deleteAllById(java.lang.Iterable)
	 */
	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		productReponsitory.deleteAllById(ids);
	}

	/**
	 * @param entities
	 * @see org.springframework.data.repository.CrudRepository#deleteAll(java.lang.Iterable)
	 */
	@Override
	public void deleteAll(Iterable<? extends Product> entities) {
		productReponsitory.deleteAll(entities);
	}

	/**
	 * 
	 * @see org.springframework.data.repository.CrudRepository#deleteAll()
	 */
	@Override
	public void deleteAll() {
		productReponsitory.deleteAll();
	}

	/**
	 * @param id
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#getById(java.lang.Object)
	 */
	@Override
	public Product getById(Long id) {
		return productReponsitory.getById(id);
	}

	/**
	 * @param <S>
	 * @param example
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll(org.springframework.data.domain.Example)
	 */
	@Override
	public <S extends Product> List<S> findAll(Example<S> example) {
		return productReponsitory.findAll(example);
	}

	/**
	 * @param <S>
	 * @param example
	 * @param sort
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll(org.springframework.data.domain.Example, org.springframework.data.domain.Sort)
	 */
	@Override
	public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
		return productReponsitory.findAll(example, sort);
	} 
	
	
}
