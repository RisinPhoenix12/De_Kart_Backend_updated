package com.deloitte.mockProj.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deloitte.mockProj.backend.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	@Query(value = "SELECT * FROM products WHERE name = ?1 AND seller_id = ?2 ", nativeQuery = true)
	Product findIfExists(String name, Integer seller_id);

}
