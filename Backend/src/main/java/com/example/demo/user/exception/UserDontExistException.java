package com.example.demo.user.exception;

import com.example.demo.common.exception.RESTException;

import static com.example.demo.user.constant.Message.USER_DONT_EXIST;

public class UserDontExistException extends RESTException {
    public UserDontExistException(){
        super(USER_DONT_EXIST.getMessage());
    }
}
