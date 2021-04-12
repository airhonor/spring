package com.honorzhang.code.student.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.sf.json.JSONObject;

/**
 * @program: feign_test
 * @author: zgr
 * @create: 2019-11-12 23:10
 **/
@Data
public class Student {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 学生学号
     */
    private String studentId;

}
