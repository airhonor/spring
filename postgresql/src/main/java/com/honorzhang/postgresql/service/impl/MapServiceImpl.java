package com.honorzhang.postgresql.service.impl;

import com.honorzhang.postgresql.mapper.MyMapMapper;
import com.honorzhang.postgresql.model.MapElement;
import com.honorzhang.postgresql.service.MapService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private MyMapMapper myMapMapper;

    @Override
    public List<MapElement> findAll() {
        return myMapMapper.findAll();
    }

    @Override
    public void addMapElement(MapElement mapElement) {
        myMapMapper.addMapElement(mapElement);
    }

    @Override
    public MapElement findById(Long id) {
        return myMapMapper.findById(id);
    }

    @Override
    public void updateMapElement(MapElement mapElement) {
        myMapMapper.updateMapElement(mapElement);
    }

    @Override
    public void deleteMapElement(Long id) {
        myMapMapper.deleteMapElement(id);
    }

    @Override
    public List<MapElement> findMapElementByCircle(String geometry, String type, String subType, double radius) {
        return myMapMapper.findMapElementByCircle(geometry, type, subType, radius);
    }


}
