package com.honorzhang.quartzdemo.ctrl;

import com.honorzhang.quartzdemo.service.InterruptConditionService;
import com.honorzhang.quartzdemo.service.ScheduleService;
import com.honorzhang.quartzdemo.vo.StatusVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: quartz-demo
 * @author: zgr
 * @create: 2020-03-25 23:23
 **/

@Slf4j
@RestController
public class JobController {
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private InterruptConditionService interruptConditionService;

    @GetMapping("/run")
    public ResponseEntity<StatusVO> run() throws Exception {
        scheduleService.runScheduleJob();
        return ResponseEntity.ok(StatusVO.environmentVerificationInconformity);
    }

    @GetMapping("/interruption")
    public ResponseEntity<String>  runInterruption() {
        interruptConditionService.run();
        return ResponseEntity.ok("success");
    }


}
