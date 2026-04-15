package com.escola.escola_projeto.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(String mensage){
        super(mensage);
    }
}
