package com.honorzhang.postgresql.service;

import com.honorzhang.postgresql.model.MapElement;

import java.util.List;
import java.util.Map;

public interface MapService {

    /**
     * @return 返回全部的mapElement
     */
    List<MapElement> findAll();

    /**
     * 条件查找
     * @param mapElement
     * @return 复合条件的地图元素
     */
    List<MapElement> findMapElementByCondition(MapElement mapElement);

    /**
     * @param mapElement
     */
    void addMapElement(MapElement mapElement);

    /**
     * @param id
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
     * 圆形区域查找
     * @param geometry 地理信息
     * @param radius 区域半径，单位为km
     * @return 以给定点为原型，radis为半径的区域中满足条件的元素的集合
     */
    List<MapElement> findMapElementByCircle(String geometry, double radius);

    /**
     * 多边形区域查找
     * @param geometry 对变形地理信息
     * @return 给定多边形区域中满足条件的元素的集合
     */
    List<MapElement> findMapElementByPolygon(String geometry);

    void addTest(Map<String, Object> map);


}
