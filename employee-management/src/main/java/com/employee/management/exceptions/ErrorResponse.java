package com.employee.management.exceptions;

import java.time.LocalDateTime;

public class ErrorResponse {
	
	private int status;
	
	private String error;
	
	private String path;
	
	private LocalDateTime timeStamp;


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}	
	
	
	@Override
	public String toString() {
		return "ErrorResponse [status=" + status + ", error=" + error + ", path=" + path + ", timeStamp=" + timeStamp
				+ "]";
	}
	
}
