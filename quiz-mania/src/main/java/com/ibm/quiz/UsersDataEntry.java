package com.ibm.quiz;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.quiz.entity.User;
import com.ibm.quiz.service.UserService;
 
@Component
public class UsersDataEntry {
	@Autowired
	private UserService service;
	
	@EventListener
	public void onAppReady(ApplicationReadyEvent are) {
		if(service.getAllUsers().size()==0) {
			
			try {
				ObjectMapper mapper=new ObjectMapper();
				User[] users=mapper.readValue(getClass().getClassLoader().getResource("user.json"),User[].class);
				for(User u:users)
					service.addUser(u);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
