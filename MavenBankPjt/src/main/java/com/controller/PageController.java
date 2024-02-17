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

		UserDTO user = new UserDTO(username, phoneNo, userAddress, email, password, cfpassword);
		  if(userDAO.saveUserDetails(user)) {
			  
	    	   return "redirect:/Login";
			}else {
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
			model.addAttribute("success", "Login successful.");
			return "Welcome";
		} else {
			model.addAttribute("error", "Invalid username or password.");
			return "Login";
		}
	}

	@GetMapping("/Addaccount")
	public ModelAndView getAddBankPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("AddAccount");
		return mv;
	}

	@PostMapping("/Addaccount")
	public String processAddAccount(HttpServletRequest request, HttpServletResponse response, Model model) {

		String userId_string = request.getParameter("userId");
		int userId = Integer.parseInt(userId_string);
		String bankAccountNo = request.getParameter("accountNumber");
		String bankName = request.getParameter("bankName");
		String ifscCode = request.getParameter("ifscCode");
		String accountType = request.getParameter("accountType");
		String money = request.getParameter("initialBalance");
		double currentBalance = Double.parseDouble(money);

		BankDTO bank = new BankDTO(userId, bankAccountNo, bankName, ifscCode, accountType, currentBalance);
		if (userDAO.saveBankDetails(bank)) {

			return "redirect:/Login";
		} else {
			model.addAttribute("error", "something went wrong");
			return "redirect:/Addaccount";
		}

	}

}