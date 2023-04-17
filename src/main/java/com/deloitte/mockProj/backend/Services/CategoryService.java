package com.deloitte.mockProj.backend.Services;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.deloitte.mockProj.backend.Repository.CategoryRepo;
import com.deloitte.mockProj.backend.dtos.Response;
import com.deloitte.mockProj.backend.entity.Categories;

@Service
public class CategoryService {

	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	Categories ctg;
	
	public Response<Categories> addCategoryService(String name, String description, String image) {
		
		Response<Categories> res = new Response<Categories>();
		
		Categories chk = categoryRepo.findByName(name);
		if (chk != null) {
			res.setSuccess(false);
			res.setMessage("Exists:Category Already Exists");
		} 
		else {
			ctg.setName(name);
			ctg.setImage(image);
			ctg.setDescription(description);
			categoryRepo.save(ctg);
			
			res.setData(ctg);
			res.setSuccess(true);
			res.setMessage("NewCategory: New Category Added");
		}
		
		
		return res;
	}
	
	public Response<List<Categories>> getAllCategories() {
		Response<List<Categories>> categories = new Response<List<Categories>>();
		categories.setData(categoryRepo.findAll());
		return categories;
	}
}
