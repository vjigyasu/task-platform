package com.smarttask.taskplatform.response;

import com.smarttask.taskplatform.response.ApiResponse;

public class SuccessResponse<T> extends ApiResponse<T> {

    public SuccessResponse(String message, T data) {
        super(message, 200, data);
    }
}