package com.honorzhang.exception.demo.exception;

import lombok.Data;

/**
 * @program: ump-server
 * @author: zgr
 * @create: 2020-04-15 17:23
 **/
@Data
public class TelemetryReceiveException extends SuperException{

    public TelemetryReceiveException(String id){
        super(id);
        super.setMsg("this is another msg");
    }

}
