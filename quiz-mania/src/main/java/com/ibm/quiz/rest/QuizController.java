package com.ibm.quiz.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.quiz.entity.User;
import com.ibm.quiz.service.QuizService;

@Controller
public class QuizController {
	@Autowired
	private QuizService service;
	


}
