package com.ibm.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.quiz.bean.Login;
import com.ibm.quiz.entity.User;
import com.ibm.quiz.exception.InvalidRequestException;
import com.ibm.quiz.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repo;
	
	@Override
	public int addUser(User user) {
		repo.save(user);
		return user.getUid();
	}

	@Override
	public User getUser(int uid) {
		return repo.findById(uid).get();
	}

	@Override
	public User validate(Login login) {
		// TODO Auto-generated method stub
		return repo.findByUsernameAndPassword(login.getUsername(),login.getPassword());
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	
}
