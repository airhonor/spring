package com.honorzhang.postgresql.service.impl;

import com.honorzhang.postgresql.mapper.MapElementMapper;
import com.honorzhang.postgresql.model.MapElement;
import com.honorzhang.postgresql.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: postgresql
 * @description: map服务
 * @author: zgr
 * @create: 2019-07-01 14:39
 **/
@Service
public class MapServiceImpl implements MapService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MapElementMapper mapElementMapper;
    private String geometry;
    private double radius;

    @Override
    public List<MapElement> findAll() {
        return mapElementMapper.findAll();
    }

    @Override
    public List<MapElement> findMapElementByCondition(MapElement mapElement) {
        return mapElementMapper.findMapElementByCondition(mapElement);
    }

    @Override
    public void addMapElement(MapElement mapElement) {
        mapElementMapper.addMapElement(mapElement);
    }

    @Override
    public MapElement findById(Long id) {
        return mapElementMapper.findById(id);
    }

    @Override
    public void updateMapElement(MapElement mapElement) {
        mapElementMapper.updateMapElement(mapElement);
    }

    @Override
    public void deleteMapElement(Long id) {
        mapElementMapper.deleteMapElement(id);
    }

    @Override
    public List<MapElement> findMapElementByCircle(String geometry, double radius) {
        return mapElementMapper.findMapElementByCircle(geometry, radius);
    }

    @Override
    public List<MapElement> findMapElementByPolygon(String geometry) {
        return mapElementMapper.findMapElementByPolygon(geometry);
    }

    @Override
    public void addTest(Map<String, Object> map) {
        mapElementMapper.addTest(map);
    }


}
