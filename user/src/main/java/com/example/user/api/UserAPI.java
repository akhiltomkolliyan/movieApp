package com.example.user.api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.user.model.LoginDTO;
import com.example.user.model.RequestSignUp;
import com.example.user.model.UserDTO;
import com.example.user.service.UserService;

@RestController
@CrossOrigin
public class UserAPI {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserService userService;

	// Fetches details of a specific user
	@RequestMapping(value = "/userdetails/{userName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO getUserDetails(@PathVariable String userName) {
		try {
		logger.info("Userdetails request for  {}", userName);
		return userService.getUserDetails(userName);
		}
		catch (Exception ex) {
			throw ex;
		}
	}

	// adds new user
	@PostMapping(value = "/user/signup")
	public String registerUser(@RequestBody RequestSignUp requestSignup) {
		try {
			String message;
			message = userService.registerUser(requestSignup);
			return message;
		} catch (Exception ex) {
			throw ex;
		}

	}
	
	// updates user details
	@PutMapping(value = "/user/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateUser(@PathVariable Integer userId, @RequestBody UserDTO user) {
		String message;
		message = userService.updateUser(userId, user);
		return message;
	} 

	// validates user with password
	@PostMapping(value = "/login")
    public String validateUser(@RequestBody LoginDTO user) throws Exception{
		String message;
                     message = userService.validateUser(user);
                    return message;
    	} 
	
	// deletes user
			@RequestMapping(value = "user/{userId}", method = RequestMethod.DELETE )
			public String delete(@PathVariable Integer userId) {
				String message;
				message = userService.delete(userId);
				return message;
			} 
}