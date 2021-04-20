package com.ibm.quiz.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "questions")
public class Question {
	@Id
	@GeneratedValue
	private int qid;
	
	@Column(length = 50)
	private String question;
	@Transient
	private String answer;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "qcode")
	private Quiz quiz;
	@JsonBackReference
	@OneToMany(mappedBy = "que",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Option> options=new ArrayList<Option>();

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	
}
