package com.ibm.quiz.rest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.quiz.entity.Option;
import com.ibm.quiz.entity.Question;
import com.ibm.quiz.entity.Quiz;
import com.ibm.quiz.entity.User;
import com.ibm.quiz.exception.InvalidRequestException;
import com.ibm.quiz.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired 
	private QuizService service;
	
	@PostMapping(value = "/create/{topic}")
	public String createQuiz(@PathVariable("topic") String topic, HttpSession session) {
		User user = (User) session.getAttribute("USER");
		if(user.getRole().equals("Admin")) {
		Quiz q = new Quiz();
		q.setTopic(topic);
		int qcode = service.addQuiz(q);
		return "Quiz added with ID: " + qcode;
	    }
		else
			return "Only an Admin can create a Quiz";
	}
	
	@PostMapping(value = "/addQue/{code}", consumes = "application/json")
	public String addQuestion(@RequestBody Question que,  @PathVariable int code) {
		int qid = service.addQuestion(que, code);
		return "Question added with id : " + qid;
	}
	
	@PostMapping(value = "/addOpt/{qid}", consumes = "application/json")
	public String add(@RequestBody Option op, @PathVariable int qid) {
		int opid = service.addOption(op, qid);
		return "Option added with id : " + opid;
	}
	
	@GetMapping(value = "/getQ/{qid}", produces = "application/json")
	public Question getQuestion(@PathVariable int qid) {
		return service.getQuestion(qid);
	}
	
	@GetMapping(value = "/get/{code}", produces = "application/json")
	public ResponseEntity<?> getQuiz(@PathVariable int code, HttpSession session) throws InvalidRequestException  {
		if(session.getAttribute("USER") != null)
		return new ResponseEntity<Quiz>(service.getQuiz(code), HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry! You are not logged in",HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/submit", consumes = "application/json")
	public void submitQuiz(@RequestBody Quiz q){
		 service.submitQuiz(q);
	}

}