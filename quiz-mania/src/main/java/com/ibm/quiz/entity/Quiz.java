package com.ibm.quiz.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name ="quizes")
public class Quiz {

	@Id
	@GeneratedValue
	private int qcode;
	@Column(length = 15)
	private String topic;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<Question> question = new ArrayList<Question>();

	public int getQcode() {
		return qcode;
	}

	public void setQcode(int qcode) {
		this.qcode = qcode;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}

	
	
}