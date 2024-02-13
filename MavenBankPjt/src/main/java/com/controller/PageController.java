package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.entity.BankDTO;
import com.dao.UserDAO;
import com.entity.UserDTO;

@Controller
public class PageController {

	UserDAO userDAO = new UserDAO();

	@GetMapping("/Registration")
	public ModelAndView getRegistrationPage() {
		ModelAndView mv = new ModelAndView();
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

		UserDTO user = new UserDTO(username, password, phoneNo, email, userAddress, cfpassword);

		if (userDAO.saveUserDetails(user)) {
			return "redirect:/Login";
		} else {
			return "redirect:/Registration";
		}
	}

	@GetMapping("/Login")
	public String showLoginForm() {
		return "Login";
	}

	@PostMapping("/Login")
	public String processLogin(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session, Model model) {

		UserDTO user = userDAO.showUserDetails(username, password);
		if (user != null) {
			List<BankDTO> bank = userDAO.getBankDetailsByUserId(user.getId());
			session.setAttribute("user", user);
			model.addAttribute("banklist", bank);
			return "home";
		} else {
			return "redirect:/Login";
		}
	}

}