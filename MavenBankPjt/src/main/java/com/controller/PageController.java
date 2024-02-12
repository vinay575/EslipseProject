package com.controller;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.dao.UserDao;
import com.entity.UserDTO;


@Controller
public class PageController {
	
	UserDao userDAO= new UserDao();
	@GetMapping("/Registration")
	public ModelAndView  getRegistrationPage() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("Registration");
		return mv;
	}
	@PostMapping("/Registration")
	public String getUserDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("name");
		 String phoneNo = request.getParameter("phoneNo");
		  String userAddress = request.getParameter("address");
		  String email = request.getParameter("email");
		  String password = request.getParameter("password");
		  String cfpassword = request.getParameter("confirmPass");
     
       
       
		  UserDTO user= new UserDTO(username,password,phoneNo,email,userAddress,cfpassword);
		    
	       if(userDAO.saveUserDetails(user)) {
	    	   return "redirect:/login";
			}else {
				return "redirect:/Registration";
				}
	}

}