package com.medclinic.exception;

public class NotUniqueUserRegistrationException extends RuntimeException{
    public NotUniqueUserRegistrationException(String message) {
        super(message);
    }
}
