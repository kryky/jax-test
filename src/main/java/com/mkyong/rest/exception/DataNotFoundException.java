package com.mkyong.rest.exception;

/**
 * Created by UI61LN on 7/17/2017.
 */
public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException(String message) {
        super(message);
    }
}
