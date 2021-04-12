package com.honorzhang.exception.demo.service;

import com.honorzhang.exception.demo.exception.TelemetryReceiveException;
import org.springframework.stereotype.Service;

/**
 * @program: exception-demo
 * @author: zgr
 * @create: 2020-04-24 15:31
 **/
@Service
public class ExceptionTestService {

    public String testException(String id, String msg) throws TelemetryReceiveException {
        throw new TelemetryReceiveException(id);
    }
}
