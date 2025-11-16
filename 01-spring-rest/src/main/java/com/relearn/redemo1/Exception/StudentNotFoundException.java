package com.relearn.redemo1.Exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String message)
    {
        super(message);
    }

}
