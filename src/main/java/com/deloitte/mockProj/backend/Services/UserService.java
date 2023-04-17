package com.deloitte.mockProj.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.deloitte.mockProj.backend.Repository.UserRepo;
import com.deloitte.mockProj.backend.dtos.Response;
import com.deloitte.mockProj.backend.entity.LoginUser;
import com.deloitte.mockProj.backend.entity.User;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	User currUser;

	public Response<User> addNewUserService(User newUser) {

		Response<User> res = new Response<User>();
		currUser.setUser_id(0);
		currUser.setUsername(newUser.getUsername());

		User chkUser = userRepo.findByUsername(newUser.getUsername());
		if (chkUser != null) {
			res.setSuccess(false);
			res.setMessage("UserName:User Already Exists");
		} else {
			currUser.setName(newUser.getName());
			currUser.setPhonenumber(newUser.getPhonenumber());
			currUser.setPassword(newUser.getPassword());
			currUser.setRole(newUser.getRole());
			currUser.setAddress(newUser.getAddress());
			userRepo.save(currUser);
			res.setSuccess(true);
			res.setMessage("NewUser:New User Created");
		}
		res.setTotalUsers(userRepo.findTotalUsers());
		return res;
	}

	public Response<User> getUser(LoginUser lUser) {

		Response<User> res = new Response<User>();
		User chkUser = userRepo.findByUsername(lUser.getUsername());

		if (chkUser == null) {
			res.setMessage("UserName:User Does Not Exist");
			res.setSuccess(false);
		} else {
			if (chkUser.getPassword().equals(lUser.getPassword())) {
				res.setData(chkUser);
				res.setMessage("Success");
				res.setSuccess(true);
			} else {
				res.setMessage("Password:Wrong password");
				res.setSuccess(false);
			}
		}
		res.setTotalUsers(userRepo.findTotalUsers());
		return res;

	}

}
