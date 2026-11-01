package com.exosoft.estoque_api.shared.domain.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) { super(message); }
}