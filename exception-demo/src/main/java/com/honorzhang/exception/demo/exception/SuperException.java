package com.honorzhang.exception.demo.exception;

import lombok.Data;

/**
 * @program: exception-demo
 * @author: zgr
 * @create: 2020-04-24 15:27
 **/
@Data
public class SuperException extends Exception{
    /**
     * id
     */
    private String id;

    /**
     * msg
     */
    private String msg;

    public SuperException(String id, String msg){
        super(msg);
        this.msg = msg;
        this.id = id;

    }
    public SuperException(String id){
        this.id = id;
    }
}
