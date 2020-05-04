package com.example.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.user.dao.UserDAO;
import com.example.user.entity.UserEntity;
import com.example.user.model.LoginDTO;
import com.example.user.model.RequestSignUp;
import com.example.user.model.UserDTO;

@Service
public class UserServicelmpl implements UserService {

	@Autowired
	UserDAO userDAO;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public UserDTO getUserDetails(String userName) {

		logger.info("Calldetails request for customer {}", userName);

		UserEntity userEntity = userDAO.findByUserName(userName);

		UserDTO userDTO = new UserDTO();

		userDTO = UserDTO.valueOf(userEntity);
		return userDTO;
	}
	
	public String registerUser(RequestSignUp user) {
		String message = null;
		UserEntity user1 = new UserEntity();
			user1.setUserName(user.getUserName());
			user1.setPhoneNumber(user.getPhoneNumber());
			user1.setEmailId(user.getEmailId());
			user1.setPassword(user.getPassword());
			message = user.getUserName() + " has been added successfully";
			userDAO.save(user1);
		return message;
	}
	
	public String delete(Integer userId) {
		String message = null;
		UserEntity user1 = new UserEntity();
		user1 = userDAO.findByUserId(userId);
		if ( user1.getUserId().equals(userId)){
			message = user1.getUserName() + " has been deleted successfully";
			userDAO.delete(user1);
			
		}
		return message;

	}
	
	@Override
	public String validateUser(LoginDTO user) throws Exception {
        String message =null;
        UserEntity user1=userDAO.findByUserName(user.getUserName());
        if(user1.getPassword().equals(user.getPassword())){
                        message = user.getUserName() +" has logged in successfully";
        }
        else {
        	message = " Invalid credentials";
        }
        return message;
	}
	

	public String updateUser(Integer userId, UserDTO user) {
		String message = null;
		UserEntity user1 = new UserEntity();
		user1 = userDAO.findByUserId(userId);
		message = user.getUserName() + " has been updated successfully";
		user1.setUserName(user.getUserName());
		user1.setPassword(user.getPassword());
		user1.setPhoneNumber(user.getPhoneNumber());
		user1.setEmailId(user.getEmailId());
		userDAO.save(user1);
		return message;
	}

}

