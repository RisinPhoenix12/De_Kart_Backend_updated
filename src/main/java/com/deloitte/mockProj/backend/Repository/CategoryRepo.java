package com.deloitte.mockProj.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deloitte.mockProj.backend.entity.Categories;

@Repository
public interface CategoryRepo extends JpaRepository<Categories, String> {

	@Query(value = "SELECT * FROM CATEGORIES WHERE name = ?1", nativeQuery = true)
	Categories findByName(String name);
	
}
