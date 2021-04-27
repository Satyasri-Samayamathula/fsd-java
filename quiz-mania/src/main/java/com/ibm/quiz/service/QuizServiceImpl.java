package com.ibm.quiz.service;


import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.quiz.bean.Login;
import com.ibm.quiz.entity.Option;
import com.ibm.quiz.entity.Question;
import com.ibm.quiz.entity.Quiz;
import com.ibm.quiz.entity.User;
import com.ibm.quiz.exception.InvalidRequestException;
import com.ibm.quiz.repo.OptionRepository;
import com.ibm.quiz.repo.QuestionRepository;
import com.ibm.quiz.repo.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepository zrepo;
	
	@Autowired
	private QuestionRepository qrepo;
	
	@Autowired 
	private OptionRepository orepo;
	
	@Override
	public int addQuiz(Quiz q) {
		zrepo.save(q);
		return q.getQcode();
	}

	
	@Override
	public Quiz getQuiz(int qcode) throws InvalidRequestException {
		Quiz q =  zrepo.findById(qcode).get();
		return q;
	}

	@Override
	public int addQuestion(Question que, int qcode) {
		
		Quiz quiz  = zrepo.findById(qcode).get();
		quiz.getQuestion().add(que);
		que.setQuiz(quiz);
		qrepo.save(que);
		return que.getQid();
	}

	@Override
	public int addOption(Option opt, int qid) {
		Question que = qrepo.findById(qid).get();
		que.getOpt().add(opt);
		opt.setQue(que);
		orepo.save(opt);
		return opt.getOpid();
	}


	@Override
	public String submitQuiz(Quiz q) {
		int totalQues = q.getQuestion().size();
		int count = 0;
		for(Question que : q.getQuestion()) {
			for(Option op: que.getOpt())
		        if(op.getFlag() == 1 && op.getOption() == que.getAnswer())
		        	count++;
			
		}
		System.out.println("Correct Ans: " + count + " out of " + totalQues);
		double per = (count * 100.0)/totalQues;
		if(per >= 50.0)
			return "Percentage: " + per + "\tResult: PASS";
		else
			return "Percentage: " + per + "\tResult: FAIL";
		
	}


	@Override
	public Question getQuestion(int qid) {
		Question q =  qrepo.findById(qid).get();
		return q;
	}
	
}