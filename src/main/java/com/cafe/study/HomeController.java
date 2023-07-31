package com.cafe.study;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe.study.model.User;
import com.cafe.study.repository.UserRepository;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/home")
	@ResponseBody
	public String goHome(HttpServletRequest request) {
		System.out.println("enter");
		
		List<User> list = userRepository.findAll();

		return list.toString();
		
	}
}
	