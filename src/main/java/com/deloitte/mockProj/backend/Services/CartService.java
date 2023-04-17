package com.deloitte.mockProj.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.mockProj.backend.Repository.CartDao;
import com.deloitte.mockProj.backend.dtos.Response;
import com.deloitte.mockProj.backend.entity.Cart;

@SuppressWarnings("deprecation")
@Service
public class CartService {
	
	@Autowired
	private CartDao cartDao;

	public Response<Cart> getCart(Integer user_id) {
		
		Response<Cart> res = new Response<Cart>();
		Cart userCart= cartDao.findById(user_id).get();
		
		res.setData(userCart);
		res.setSuccess(true);
		
		return res;
	}

	public Response<Cart> updateCart(String currCart, Integer user_id) {
		/*cartDao.updateUsrCart(user_id, currCart);*/
		
		Response<Cart> res = new Response<Cart>();
		if(cartDao.existsById(user_id))
		{
			Cart tobeChanged = cartDao.getOne(user_id);
			tobeChanged.setCart_details(currCart);
			res.setData(cartDao.save(tobeChanged));
			res.setSuccess(true);
			}
		else {
			Cart tobeAdded = new Cart();
			tobeAdded.setCart_details(currCart);
			tobeAdded.setUser_id(user_id);
			res.setData(cartDao.save(tobeAdded));
			res.setSuccess(true);
			
		}
		return res;
	}
}
