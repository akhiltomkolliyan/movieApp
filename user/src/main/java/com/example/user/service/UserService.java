package com.example.user.service;
import com.example.user.model.LoginDTO;
import com.example.user.model.RequestSignUp;
import com.example.user.model.UserDTO;

public interface UserService {

	UserDTO getUserDetails(String userName);
	String registerUser(RequestSignUp requestSignup);
	String delete(Integer userId);
	String validateUser(LoginDTO user) throws Exception;
	String updateUser(Integer userId, UserDTO user);
}