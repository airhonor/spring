package com.honorzhang.code.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.honorzhang.code.student.mapper.StudentMapper;
import com.honorzhang.code.student.model.Student;
import com.honorzhang.code.student.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: feign_test
 * @author: zgr
 * @create: 2019-11-13 22:51
 **/
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentMapper mapper;

    public StudentServiceImpl(StudentMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Student> findAll() {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        return mapper.selectList(wrapper);
    }
}
