package com.honorzhang.mybatisplustest.service;

import com.honorzhang.mybatisplustest.mapper.StudentMapper;
import com.honorzhang.mybatisplustest.model.Classes;
import com.honorzhang.mybatisplustest.model.Student;
import com.honorzhang.mybatisplustest.model.StudentClassesId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: mybatisplustest
 * @author: zgr
 * @create: 2019-09-05 08:42
 **/
@Service
public class StudentService {
    private final StudentMapper studentMapper;

    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    /**
     * 全部查找
     *
     * @return 全部数据
     */
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    /**
     * id查找
     *
     * @param id id
     * @return id对应数据
     */
    public Student findById(Long id) {
        return studentMapper.findById(id);
    }

    /**
     * id删除
     *
     * @param id
     */
    public int deleteStudent(Long id) {
        return studentMapper.deleteStudent(id);
    }

    /**
     * 更新数据
     *
     * @param student
     */
    public Long updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    /**
     * 添加数据
     *
     * @param student
     */
    public Long addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    /**
     * 删除关系表
     *
     * @param studentId student_id
     * @return 删除的行数
     */
    public int deleteStudentClassesId(Long studentId) {
        return studentMapper.deleteStudentClassesId(studentId);
    }

    /**
     * 添加课程号信息
     *
     * @param student 关系列表
     * @return id
     */
    public Long addStudentClassesId(Student student) {
        List<StudentClassesId> studentClassesIdList = new ArrayList<>();
        for (Classes classes : student.getClasses()) {
            StudentClassesId studentClassesId = new StudentClassesId();
            studentClassesId.setStudentId(student.getStudentId());
            studentClassesId.setClassesId(classes.getId());
            studentClassesIdList.add(studentClassesId);

        }
        return studentMapper.addStudentClassesId(studentClassesIdList);
    }
}
