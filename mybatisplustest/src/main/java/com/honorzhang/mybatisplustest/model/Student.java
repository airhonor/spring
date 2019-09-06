package com.honorzhang.mybatisplustest.model;

import lombok.Data;

import java.util.Set;

/**
 * @program: mybatisplus
 * @author: zgr
 * @create: 2019-08-15 09:28
 **/
@Data
public class Student {
    /**
     * id
     */
    private Long id;

    /**
     * 学生的姓名
     */
    private String name;

    /**
     * 学生学号
     */
    private Long studentId;

    /**
     * 学生选择的课程号
     */
    private Set<Classes> classes;
}
