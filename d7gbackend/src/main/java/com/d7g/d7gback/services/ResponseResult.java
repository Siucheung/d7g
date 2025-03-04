package com.d7g.d7gback.services;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseResult<T> {
    private Boolean success;
    private T data;

    public static <T> ResponseResult<T> success(T data) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setSuccess(true);
        result.setData(data);
        return result;
}
}