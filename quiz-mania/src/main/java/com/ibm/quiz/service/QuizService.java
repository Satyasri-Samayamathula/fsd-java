package com.ibm.quiz.service;

import com.ibm.quiz.entity.Option;
import com.ibm.quiz.entity.Question;
import com.ibm.quiz.entity.Quiz;

public interface QuizService {
	
	int addQuiz(Quiz quiz);
	
	Quiz getQiuz(int qcode);
	
	Question getQuestion(int qid);
	
	int addQuestion(Question que,int qcode);
	
	int addOption(Option opt,int qid);
	
	
	
}
