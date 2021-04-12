package com.honorzhang.code.student.service;

import com.honorzhang.code.student.model.Student;

import java.util.List;

/**
 * @program: feign_test
 * @author: zgr
 * @create: 2019-11-13 22:49
 **/
public interface StudentService {

    /**
     * 全部查询
     * @return 全部学生信息
     */
    List<Student> findAll();
}
