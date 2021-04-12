package com.honorzhang.code.student.model.dto;

import com.honorzhang.code.student.model.Student;
import lombok.Data;
import net.sf.json.JSONObject;

/**
 * @program: feign_test
 * @author: zgr
 * @create: 2019-11-13 22:57
 **/
@Data
public class StudentPageModel extends Student {
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
