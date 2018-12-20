package com.cattool.application.dao;

import java.io.Serializable;

public class FeedbackDao implements Serializable{

	private int feedbackId;
	private String userName;
	private String question1;
	private String question2;
	private String question3;
	private String recommend;
	private String other;
	private int rating;
	private int clientId;
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getQuestion1() {
		return question1;
	}
	public void setQuestion1(String question1) {
		this.question1 = question1;
	}
	public String getQuestion2() {
		return question2;
	}
	public void setQuestion2(String question2) {
		this.question2 = question2;
	}
	public String getQuestion3() {
		return question3;
	}
	public void setQuestion3(String question3) {
		this.question3 = question3;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", userName=" + userName + ", question1=" + question1
				+ ", question2=" + question2 + ", question3=" + question3 + ", recommend=" + recommend + ", other="
				+ other + ", rating=" + rating + ", clientId=" + clientId + "]";
	}
	
}
