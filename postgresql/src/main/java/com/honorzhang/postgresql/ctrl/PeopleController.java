package com.honorzhang.postgresql.ctrl;

import com.honorzhang.postgresql.model.People;
import com.honorzhang.postgresql.service.PeopleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：zgr
 * @date ：Created in 2019/6/10
 */
@Slf4j
@RestController
@RequestMapping("/bim/people")
public class PeopleController {
    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    /**
     * 全部查找
     *
     * @return 所有人员数据
     */
    @GetMapping("/list")
    public List<People> findAll() {
        return peopleService.findAll();
    }



}
