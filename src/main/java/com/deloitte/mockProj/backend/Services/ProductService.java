package com.deloitte.mockProj.backend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.mockProj.backend.Repository.ProductRepo;
import com.deloitte.mockProj.backend.dtos.Response;
import com.deloitte.mockProj.backend.entity.Product;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;

	public Response<Product> addProductService(Product prodToAdd ) {
			
		System.out.println(prodToAdd);
		Response<Product> res = new Response<Product>();
		
		Product pdt = productRepo.findIfExists(prodToAdd.getName(), prodToAdd.getSeller_id());
		
		if(pdt!=null) {
			res.setSuccess(false);
			res.setMessage("Exists:Product Already Exists");
		}
		else {
			res.setData(productRepo.save(prodToAdd));
			res.setSuccess(true);
			res.setMessage("NewProduct: New Product Added");
		}
		return res;
	}
	
	public Response<List<Product>> getAllProductService() {
		Response<List<Product>> pdts = new Response<List<Product>>();
		pdts.setData(productRepo.findAll());
		return pdts;
	}
}
