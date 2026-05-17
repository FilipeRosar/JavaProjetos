package com.livraria.books_on.infrastructure.exception;



public class BussinessException extends RuntimeException {
    public BussinessException(String mensage){
        super(mensage);
    }
}
