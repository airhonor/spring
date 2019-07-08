package com.honorzhang.postgresql.mapper;

import com.honorzhang.postgresql.model.People;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：zgr
 * @date ：Created in 2019/6/10
 */
@Mapper
public interface PeopleMapper{


    /**
     * 查找全部人员
     * @return 查询结果
     */
    List<People> selectAll();

    /**
     * id查找
     *
     * @param id id
     * @return id对应的人员数据
     */
    People findById(Long id);

    /**
     * 更新人员
     *
     * @param people 更新人员信息
     */
    void updatePeople(People people);

    /**
     * id删除
     *
     * @param id id
     */
    void deletePeople(Long id);

    /**
     * 添加人员
     *
     * @param people 添加人员信息
     */
    void addPeople(People people);

    /**
     * 条件查找
     *
     * @param people 人员的某条件信息
     * @return 符合条件的人员信息
     */
    List<People> findByCondition(People people);
}
