package com.cafe.study.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cafe.study.model.User;
import com.cafe.study.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	
	private UserRepository userRepository;

	public User getLoginUser(String id) {
		
		Optional<User> user = userRepository.findById(id);
		return user.get();
	}

	/*
	public List<User> selectAll(){
		return Usermapper.selectAll();
	}
	
	
	public void registerUser(User user) {
		Usermapper.create(user);
	}
	
	public void updateUser(User user) {
		Usermapper.update(user);
	}
	
	public void gradeUpdate(String userId, int grade) {
		Usermapper.gradeUpdate(userId, grade);
	}
	
	public void joinDateUpdate(String userId, Date date) {
		Usermapper.joinDateUpdate(userId, date);
	}
	
	public void delete(String userId) {
		Usermapper.delete(userId);
	}
	
	public User identifyUser(Map userMap) {
		return Usermapper.authenticatedUser(userMap);
	}
	
	public int idCheck(String userId) {
		return Usermapper.idCheck(userId);
	}
	
	public User selectById(String userId) {
		return Usermapper.selectById(userId);
	}*/
}
