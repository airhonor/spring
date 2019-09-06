package com.honorzhang.mybatisplustest.ctrl;

import com.honorzhang.mybatisplustest.model.Student;
import com.honorzhang.mybatisplustest.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: mybatisplustest
 * @author: zgr
 * @create: 2019-09-05 08:58
 **/
@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * 全部查找
     *
     * @return 全部数据
     */
    @GetMapping("/list")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    /**
     * id查找
     *
     * @param id id
     * @return id对应数据
     */
    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    /**
     * id删除
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        if (studentService.findById(id) == null) {
            log.error("信息已被删除");
            return null;
        }
        int resultStudent = Integer.MIN_VALUE;
        int deleteRelationResult = Integer.MIN_VALUE;

        try {
            resultStudent = studentService.deleteStudent(id);
            deleteRelationResult = studentService.deleteStudentClassesId(studentService.findById(id).getId());
        } catch (Exception e) {
            log.error("删除学生信息失败{}", e);
            return "出现异常,删除失败";
        }
        if (resultStudent > 0 && deleteRelationResult > 0) {
            return "删除成功";
        } else {
            return "需要删除的信息不存在,删除失败";
        }
    }

    /**
     * 更新数据
     *
     * @param student
     */
    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        if (student.getClasses() != null) {
            int deleteResult = Integer.MIN_VALUE;
            try {
                deleteResult = studentService.deleteStudentClassesId(student.getStudentId());
            } catch (Exception e) {
                log.error("出现异常，更新关系表出错{}", e);
                return null;
            }
            if (deleteResult > 0) {
                log.info("删除成功");
            } else {
                log.info("需要删除的信息不存在");
            }
            try {
                studentService.addStudentClassesId(student);
            } catch (Exception e) {
                log.error("更新关系表出现异常{}", e);
            }
        }
        try {
            Long id = studentService.updateStudent(student);
            return studentService.findById(id);
        } catch (Exception e) {
            log.error("更新失败{}", e);
            return null;
        }

    }

    /**
     * 添加数据
     *
     * @param student
     */
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        if (student.getClasses() != null) {
            try {
                studentService.addStudentClassesId(student);
            } catch (Exception e) {
                log.error("更新关系表出现异常{}", e);
            }
        }
        try {
            studentService.addStudent(student);
            Long id = student.getId();
            return studentService.findById(id);
        } catch (Exception e) {
            log.error("添加学信息出现异常{}", e);
            return null;
        }

    }
}
