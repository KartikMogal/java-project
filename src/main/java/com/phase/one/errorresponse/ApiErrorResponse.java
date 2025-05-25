package com.phase.one.errorresponse;

import org.springframework.http.HttpStatus;

public class ApiErrorResponse {
	private int status;
    private String message;

    public ApiErrorResponse(HttpStatus status, String message) {
        this.status = status.value();
        this.message = message;
    }

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ApiErrorResponse [status=" + status + ", message=" + message + "]";
	}

}
