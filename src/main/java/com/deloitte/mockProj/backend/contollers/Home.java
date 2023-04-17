package com.deloitte.mockProj.backend.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.deloitte.mockProj.backend.Services.CartService;
import com.deloitte.mockProj.backend.Services.CategoryService;
import com.deloitte.mockProj.backend.Services.ProductService;
import com.deloitte.mockProj.backend.Services.UserService;
import com.deloitte.mockProj.backend.dtos.Response;
import com.deloitte.mockProj.backend.entity.Cart;
import com.deloitte.mockProj.backend.entity.Categories;
import com.deloitte.mockProj.backend.entity.LoginUser;
import com.deloitte.mockProj.backend.entity.Product;
import com.deloitte.mockProj.backend.entity.User;

@RestController
@CrossOrigin(origins="*")
public class Home {
	
	@Autowired
	CartService cartService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;
	
	//Register User
	@PostMapping("/addUser")
	private Response<User> addNewUser(@RequestBody User newUser) {
		Response<User> res = new Response<User>();
		res=userService.addNewUserService(newUser);
		
		return res;
	}
	
	@PostMapping("/login")
	private Response<User> loginUser(@RequestBody LoginUser lUser) {
		Response<User> res = new Response<User>();
		res = userService.getUser(lUser);
		return (res);
	}
	
	//Cart Functionalities
		@GetMapping("/cart/getCart/{user_id}")
		private Response<Cart> getCartItems(@PathVariable Integer user_id) {
			
			Response<Cart> res = new Response<Cart>();
			res = cartService.getCart(user_id);
			return res;
		}
		@PostMapping("/cart/updateCart/{user_id}")
		private Response<Cart> updateCartItems(@RequestBody String currCart, @PathVariable Integer user_id) {
			
			System.out.println(currCart);
			System.out.println(user_id);
			Response<Cart> res = new Response<Cart>();
			res = cartService.updateCart(currCart, user_id);
			
			return res;
		}
		
	//Universal Store Functionalities
	
	  @GetMapping("/getCategories")
	  private Response<List<Categories>> getCategories() {
		  Response<List<Categories>> categories = new Response<List<Categories>>();
		  categories=categoryService.getAllCategories();
		  return categories;
	  }
	 
	  @GetMapping("/getAllProducts")
	  private Response<List<Product>> getAllProducts() {
		  Response<List<Product>> pdts = new Response<List<Product>>();
		  pdts = productService.getAllProductService();
		  return pdts;
	  }
		
	//Seller Functionalities
		@PostMapping("/seller/addCategory")
		private Response<Categories> addCategory(@RequestBody Categories catToAdd) {
			System.out.println(catToAdd);
			Response<Categories> addctg = categoryService.addCategoryService(catToAdd.getName(), catToAdd.getDescription(), 
					catToAdd.getImage());
			return addctg;
		}
		
		@PostMapping("/seller/addProduct")
		private Response<Product> addProduct(@RequestBody Product prodToAdd) {
			
			Response<Product> res = new Response<Product>();
			res = productService.addProductService(prodToAdd);
			return res;
		}
}
