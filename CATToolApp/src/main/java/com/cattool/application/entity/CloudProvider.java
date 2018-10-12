package com.cattool.application.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CloudProvider {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cloudProviderId;
	private String cloudProviders;
	private int evaluationOrder;
	
	public CloudProvider() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CloudProvider(int cloudProviderId, String cloudProviders, int evaluationOrder) {
		super();
		this.cloudProviderId = cloudProviderId;
		this.cloudProviders = cloudProviders;
		this.evaluationOrder = evaluationOrder;
	}
	public int getCloudProviderId() {
		return cloudProviderId;
	}
	public void setCloudProviderId(int cloudProviderId) {
		this.cloudProviderId = cloudProviderId;
	}
	public String getCloudProviders() {
		return cloudProviders;
	}
	public void setCloudProviders(String cloudProviders) {
		this.cloudProviders = cloudProviders;
	}
	public int getEvaluationOrder() {
		return evaluationOrder;
	}
	public void setEvaluationOrder(int evaluationOrder) {
		this.evaluationOrder = evaluationOrder;
	}
	
	
	@Override
	public String toString() {
		return "CloudProvider [cloudProviderId=" + cloudProviderId + ", cloudProviders=" + cloudProviders
				+ ", evaluationOrder=" + evaluationOrder + "]";
	}

	
}
