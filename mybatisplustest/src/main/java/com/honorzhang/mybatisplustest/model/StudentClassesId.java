package com.honorzhang.mybatisplustest.model;

import lombok.Data;

/**
 * @program: mybatisplustest
 * @author: zgr
 * @create: 2019-09-05 16:27
 **/
@Data
public class StudentClassesId {
    /**
     * 学生id
     */
    private Long studentId;

    /**
     * 课程号
     */
    private Long classesId;
}
