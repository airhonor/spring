package com.honorzhang.mybatisplustest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.honorzhang.mybatisplustest.model.Student;
import com.honorzhang.mybatisplustest.model.StudentClassesId;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: mybatisplustest
 * @author: zgr
 * @create: 2019-09-05 08:40
 **/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    /**
     * 全部查找
     *
     * @return 全部学生
     */
    List<Student> findAll();

    /**
     * id查找
     *
     * @param id id
     * @return id对应的数据
     */
    Student findById(Long id);

    /**
     * 删除
     *
     * @param id id
     */
    int deleteStudent(Long id);

    /**
     * 修改学生信息
     *
     * @param student 学生信息
     */
    Long updateStudent(Student student);

    /**
     * 增加学生
     *
     * @param student
     */
    Long addStudent(Student student);

    /**
     * 删除关系表
     *
     * @param id student_id
     * @return 删除的行数
     */
    int deleteStudentClassesId(Long id);

    /**
     * 添加课程号信息
     *
     * @param studentClassesIdList 关系列表
     * @return id
     */
    Long addStudentClassesId(List<StudentClassesId> studentClassesIdList);
}
