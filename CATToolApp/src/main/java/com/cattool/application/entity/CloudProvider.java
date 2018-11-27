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
	private int clientId;
	
	public CloudProvider() {
		super();
		// TODO Auto-generated constructor stub
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
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	@Override
	public String toString() {
		return "CloudProvider [cloudProviderId=" + cloudProviderId + ", cloudProviders=" + cloudProviders
				+ ", evaluationOrder=" + evaluationOrder + ", clientId=" + clientId + "]";
	}

	
}
