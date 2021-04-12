package com.honorzhang.code.student.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.sf.json.JSON;
import net.sf.json.JSONObject;

/**
 * @program: feign_test
 * @author: zgr
 * @create: 2019-11-12 23:10
 **/
@Data
public class Score {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 课程号
     */
    private String courseId;

    /**
     * 课程分数
     */
    private Integer courseScores;
}
