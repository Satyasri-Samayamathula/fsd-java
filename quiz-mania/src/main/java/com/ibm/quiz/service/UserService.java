package com.ibm.quiz.service;

import java.util.List;

import com.ibm.quiz.bean.Login;
import com.ibm.quiz.entity.User;
import com.ibm.quiz.exception.InvalidRequestException;

public interface UserService {
	
	int addUser(User user);
	
	User getUser(int uid) ;
	
	User validate(Login login);
	
	List<User> getAllUsers();
}