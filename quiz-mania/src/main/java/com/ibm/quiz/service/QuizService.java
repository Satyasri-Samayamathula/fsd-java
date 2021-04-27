package com.ibm.quiz.service;

import java.util.Collection;

import com.ibm.quiz.entity.Option;
import com.ibm.quiz.entity.Question;
import com.ibm.quiz.entity.Quiz;

import com.ibm.quiz.exception.InvalidRequestException;

public interface QuizService {

    int addQuiz(Quiz q);
	
    Quiz getQuiz(int qcode) throws InvalidRequestException;
	
    Question getQuestion(int qid);
    
    int addQuestion(Question que, int qcode);
    
    int addOption(Option opt, int qid);
    
    String submitQuiz(Quiz q);
	
}