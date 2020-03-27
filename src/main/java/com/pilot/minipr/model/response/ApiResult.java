package com.pilot.minipr.model.response;

import org.springframework.http.HttpStatus;

public class ApiResult<T> {

	private final boolean success;
	private final T response;
	private final ApiError error;

	private ApiResult(boolean success, T response, ApiError error) {
	        this.success = success;
	        this.response = response;
	        this.error = error;
	}
	
	public static <T> ApiResult<T> OK(T response) {
		return null;
//		return new ApiResult<>(true, response, null);
	}

	public static ApiResult ERROR(Throwable throwable, HttpStatus status) {
		return null;
//		return new ApiResult<>(false, null, new ApiError(throwable, status));
	}

	public static ApiResult ERROR(String errorMessage, HttpStatus status) {
		return null;
//		return new ApiResult<>(false, null, new ApiError(errorMessage, status));
	}
}
