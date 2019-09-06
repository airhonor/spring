package com.honorzhang.mybatisplustest.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.honorzhang.mybatisplustest.model.Classes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: zgr
 * @create: 2019-08-15 10:15
 **/
@Mapper
public interface ClassesMapper extends BaseMapper<Classes> {

    Classes findClassesById(@Param(Constants.WRAPPER) Wrapper<Classes> userWrapper);
}
