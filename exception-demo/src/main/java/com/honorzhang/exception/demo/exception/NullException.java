package com.honorzhang.exception.demo.exception;

/**
 * @program: exception-demo
 * @author: zgr
 * @create: 2020-04-15 22:29
 **/
public class NullException extends Exception{
    public NullException(String above_exception) {
        super(above_exception);
    }
}
