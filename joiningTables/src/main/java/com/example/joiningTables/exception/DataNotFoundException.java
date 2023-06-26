package com.example.joiningTables.exception;
public class DataNotFoundException  extends  RuntimeException{
    public DataNotFoundException(String exceptionMessage){
        super(exceptionMessage);
    }
}