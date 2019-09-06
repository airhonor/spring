package com.honorzhang.mybatisplustest.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @program: mybatisplus
 * @author: zgr
 * @create: 2019-08-15 09:35
 **/
@Data
@TableName(value = "classes")
public class Classes {
    /**
     * 课程id
     */
    private Long id;

    /**
     * 课程名
     */
    private String name;


    /**
     * 课程老师
     */
    private String teacher;
}
