package com.example.demo.HealthCheck;



public class HealthCheck {

	private String SystemName;
	private String StatusCode;
	private String StatusDescription;
	
	public HealthCheck() {
		super();
	}

	public HealthCheck(String systemName, String statusCode, String statusDescription) {
		super();
		SystemName = systemName;
		StatusCode = statusCode;
		StatusDescription = statusDescription;
	}

	public String getSystemName() {
		return SystemName;
	}

	public void setSystemName(String systemName) {
		SystemName = systemName;
	}

	public String getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(String statusCode) {
		StatusCode = statusCode;
	}

	public String getStatusDescription() {
		return StatusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		StatusDescription = statusDescription;
	}

	@Override
	public String toString() {
		return "HealthCheck [SystemName=" + SystemName + ", StatusCode=" + StatusCode + ", StatusDescription="
				+ StatusDescription + "]";
	}
	
}
