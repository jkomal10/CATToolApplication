package com.cattool.application.dao;

import java.util.List;

public class CloudProviderDAO {
	
	private int cloudProviderId;
	private String cloudProviders;
	private int clientId;
	private List<CloudProviderRuleDAO> cloudProviderRules;
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
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public List<CloudProviderRuleDAO> getCloudProviderRules() {
		return cloudProviderRules;
	}
	public void setCloudProviderRules(List<CloudProviderRuleDAO> cloudProviderRules) {
		this.cloudProviderRules = cloudProviderRules;
	}
	@Override
	public String toString() {
		return "CloudProviderDAO [cloudProviderId=" + cloudProviderId + ", cloudProviders=" + cloudProviders
				+ ", clientId=" + clientId + ", cloudProviderRules=" + cloudProviderRules + "]";
	}
	
	
	

}
