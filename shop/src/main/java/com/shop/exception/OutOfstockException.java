package com.shop.exception;

public class OutOfstockException extends RuntimeException{

    public OutOfstockException(String message){
        super(message);
    }
}
