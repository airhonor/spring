package com.honorzhang.postgresql.mapper;

import com.honorzhang.postgresql.model.MapElement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: postgresql
 * @description: map的mapper层
 * @author: zgr
 * @create: 2019-07-01 14:40
 **/
@Mapper
public interface MyMapMapper {

    /**
     * @return 返回全部的mapElement
     */
    List<MapElement> findAll();

    /**
     * @param mapElement
     */
    void addMapElement(MapElement mapElement);

    /**
     * @param id id
     * @return 依据id返回数据
     */
    MapElement findById(Long id);

    /**
     * @param mapElement
     * @return x修改后的地图元素
     */
    void updateMapElement(MapElement mapElement);

    /**
     * @param id id
     */
    void deleteMapElement(Long id);

    /**
     * @param geometry 地理信息
     * @param type 元素大类
     * @param subType 元素细分类
     * @param radius 区域半径，单位为km
     * @return 以给定点为原型，radis为半径的区域中满足条件的元素的集合
     */
    List<MapElement> findMapElementByCircle(String geometry, String type, String subType, double radius);

}