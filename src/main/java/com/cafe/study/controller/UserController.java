package com.cafe.study.controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe.study.model.User;
import com.cafe.study.service.UserService;

@Controller
@RequestMapping("/member/*")
public class UserController {

	HttpSession session;
	
	@Autowired
	private UserService service;

	@RequestMapping("/main.do")
	public String list() {
		
		return "member/login";
	}
	
	@RequestMapping("/login.do")
	public String login(ModelMap model,HttpServletRequest request, User user) {
		
		User user2 = service.getLoginUser(user.getUserId());
		
		String hashedPassword = sha256Hash(user.getUserPwd());
		
		if(user2.getUserPwd().equals(hashedPassword)){
			request.getSession().setAttribute("userId", user.getUserId());
			//로그인 성공시 접속날짜 업데이트. sql에서 SYSDATE() 또는 now() 함수를 써도됨
			Date utilDate = new Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		}
		
		return "redirect:/main/main.do";
	}
	/*
	@RequestMapping("/save.do")
	public String save(ModelMap model,HttpServletRequest request, User user) {

		String hashedPassword = sha256Hash(user.getUserPwd());
		user.setUserPwd(hashedPassword);
		//저장
		service.registerUser(user);
		return "redirect:/member/main.do";
	}
	
	@RequestMapping("/update.do")
	public String update(ModelMap model,HttpServletRequest request, User user) {

		user.setUserId((String) request.getSession().getAttribute("userId"));

		if (user.getUserPwd() == null) {
			User user2 = service.selectById(user.getUserId());
			user.setUserPwd(user2.getUserPwd());
		} else {
			String hashedPassword = sha256Hash(user.getUserPwd());
			user.setUserPwd(hashedPassword);
		}
		service.updateUser(user);

		return "redirect:/main/main.do";
	}
	
	@RequestMapping("/join.do")
	public String join(ModelMap model,HttpServletRequest request, User user) {
		return "/member/join";
	}
	
	@RequestMapping("/checkId.do")
	@ResponseBody
	public String idCheck(ModelMap model,HttpServletRequest request, @RequestParam("userId") String userID){
		String result = "";
		if(service.idCheck(userID) == 1) {
			result = "fail";
		}else {
			result = "success";
		}
		
		return result;
	}
	
	@RequestMapping("/updateForm.do")
	public String update(ModelMap model,HttpServletRequest request) {
		session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		
		User user = service.selectById(userId);
		model.addAttribute("user", user);
		return "/member/update";
	}
	
	@RequestMapping("/logout.do")
	public String logout(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
		return "redirect:/member/main.do";
	}
	
	*/
	
	public static String sha256Hash(String input) {
	    try {
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
	
	        // 해시 값을 16진수 문자열로 변환
	        StringBuilder hexString = new StringBuilder();
	        for (byte b : hash) {
	            String hex = Integer.toHexString(0xff & b);
	            if (hex.length() == 1) {
	                hexString.append('0');
	            }
	            hexString.append(hex);
	        }
	
	        return hexString.toString();
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}
