package com.honorzhang.exception.demo.ctrl;

import com.honorzhang.exception.demo.exception.SuperException;
import com.honorzhang.exception.demo.exception.TelemetryReceiveException;
import com.honorzhang.exception.demo.service.ExceptionTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: exception-demo
 * @author: zgr
 * @create: 2020-04-15 22:17
 **/
@Slf4j
@RestController
@RequestMapping("/exception")
public class ExceptionController {
    @Autowired
    private ExceptionTestService exceptionTestService;

    @GetMapping()
    public void testException(){
        String id = "123456";
        String msg = "this is exception msg";
        try{
            exceptionTestService.testException(id, msg);
        }catch (Exception e){
            log.info("", e);
            if (e instanceof SuperException){
                log.info("id: {}", ((SuperException) e).getId());
                log.info("msg: {}", ((SuperException) e).getMsg());

            }

        }
    }
}
