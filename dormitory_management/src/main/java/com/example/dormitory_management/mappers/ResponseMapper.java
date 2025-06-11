package com.example.dormitory_management.mappers;

import com.example.dormitory_management.dto.ResponseDTO;

public class ResponseMapper {
    public static <T> ResponseDTO<T> success(T data) {
        return new ResponseDTO<>("success", "Operation successful", data);
    }

    public static <T> ResponseDTO<T> success(String message, T data) {
        return new ResponseDTO<>("success", message, data);
    }

    public static <T> ResponseDTO<T> error(String message) {
        return new ResponseDTO<>("error", message, null);
    }
}
