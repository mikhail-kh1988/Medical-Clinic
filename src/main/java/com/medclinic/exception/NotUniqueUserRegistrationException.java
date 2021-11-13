package com.medclinic.exception;

public class NotUniqueUserRegistrationException extends Exception{
    public NotUniqueUserRegistrationException(String message) {
        super(message);
    }
}
