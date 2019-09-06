package com.honorzhang.mybatisplustest.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.honorzhang.mybatisplustest.mapper.ClassesMapper;
import com.honorzhang.mybatisplustest.model.Classes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: studentmanagment
 * @author: zgr
 * @create: 2019-08-15 10:14
 **/
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
@Slf4j
public class ClassesService {
    private final ClassesMapper classesMapper;

    public ClassesService(ClassesMapper classesMapper) {
        this.classesMapper = classesMapper;
    }

    /**
     * 查找全部
     *
     * @return 全部数据
     */
    public List<Classes> findAll() {
        QueryWrapper<Classes> wrapper = new QueryWrapper<>();
        return classesMapper.selectList(wrapper);
    }

    /**
     * id查找
     *
     * @param id id
     * @return id对应的数据
     */
    public Classes findById(Long id) {
        QueryWrapper<Classes> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return classesMapper.findClassesById(wrapper);
    }

    /**
     * 课程插入
     *
     * @param classes 插入的课程信息
     * @return 是否插入成功
     */
    public boolean insertClass(Classes classes) {
        try {

            int insert = classesMapper.insert(classes);
            return insert > 0;
        } catch (Exception e) {
            log.error("数据插入错误{}", classes.toString(), e);
            return false;
        }
    }

    /**
     * 课程插入
     *
     * @param classes 插入的课程信息
     * @return 是否插入成功
     */
    public boolean updateClass(Classes classes) {
        return classesMapper.updateById(classes) > 0;
    }

    /**
     * id删除
     *
     * @param id id
     * @return 是否删除成功
     */
    public boolean deleteById(Long id) {
        try {
            int deleteById = classesMapper.deleteById(id);
            return deleteById > 0;
        } catch (Exception e) {
            log.error("数据删除错误{}", id, e);
            return false;
        }
    }
}
