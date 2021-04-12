package com.honorzhang.code.student.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.honorzhang.code.student.model.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: feign_test
 * @author: zgr
 * @create: 2019-11-13 22:48
 **/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
