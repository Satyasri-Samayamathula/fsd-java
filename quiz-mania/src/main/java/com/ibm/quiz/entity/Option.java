package com.ibm.quiz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="que_opts")
public class Option {

	@Id
	@GeneratedValue
	private int opid;
	@Column(length =40)
	private String opt;
	private boolean isAnswer;
	@ManyToOne
	@JoinColumn(name="qid")
	private Question que;
	
	public int getOpid() {
		return opid;
	}
	public void setOpid(int opid) {
		this.opid = opid;
	}
	public String getOption() {
		return opt;
	}
	public void setOption(String option) {
		this.opt = option;
	}
	public boolean isAnswer() {
		return isAnswer;
	}
	public void setAnswer(boolean isAnswer) {
		this.isAnswer = isAnswer;
	}
	public Question getQue() {
		return que;
	}
	public void setQue(Question que) {
		this.que = que;
	}
}