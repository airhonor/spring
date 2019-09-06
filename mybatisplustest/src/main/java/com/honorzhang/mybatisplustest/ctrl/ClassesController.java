package com.honorzhang.mybatisplustest.ctrl;

import com.honorzhang.mybatisplustest.model.Classes;
import com.honorzhang.mybatisplustest.service.ClassesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: studentmanagment
 * @author: zgr
 * @create: 2019-08-15 10:16
 **/
@Slf4j
@RestController
@RequestMapping("/classes")
public class ClassesController {
    private final ClassesService classesService;

    public ClassesController(ClassesService classesService) {
        this.classesService = classesService;
    }

    @GetMapping("/list")
    public List<Classes> findAll() {
        return classesService.findAll();
    }

    @GetMapping("/{id}")
    public Classes findById(@PathVariable Long id) {
        return classesService.findById(id);
    }
}
