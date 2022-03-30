package edu.poly.shop.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.poly.shop.domain.Product;

@Repository
public interface ProductReponsitory extends JpaRepository<Product,Long> {

}
