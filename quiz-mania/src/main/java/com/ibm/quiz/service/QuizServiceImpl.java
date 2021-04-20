package com.ibm.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.quiz.entity.Option;
import com.ibm.quiz.entity.Question;
import com.ibm.quiz.entity.Quiz;
import com.ibm.quiz.repo.OptionRepository;
import com.ibm.quiz.repo.QuestionRepository;
import com.ibm.quiz.repo.QuizRepository;

@Service
public  class QuizServiceImpl implements QuizService {
	@Autowired
	private QuizRepository repo;
	@Autowired
	private QuestionRepository qrepo;
	@Autowired
	private OptionRepository orepo;
	@Override
	public int addQuiz(Quiz quiz) {
		repo.save(quiz);
		return quiz.getQcode();
	}
	@Override
	public Quiz getQiuz(int qcode) {
		return repo.findById(qcode).get();
	}
	
	@Override
	public int addQuestion(Question que, int qcode) {
		Quiz quiz=repo.findById(qcode).get();
		quiz.getQuestions().add(que);
		que.setQuiz(quiz);
		
		//setting to q and vice-verse
		qrepo.save(que);
		return que.getQid();
	}
	@Override
	public int addOption(Option opt, int qid) {
		Question que=qrepo.findById(qid).get();
		que.getOptions().add(opt);
		
		return 0;
	}
	
	
}
