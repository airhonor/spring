package com.honorzhang.postgresql.ctrl;

import com.honorzhang.postgresql.model.MapElement;
import com.honorzhang.postgresql.service.MapService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @program: postgresql
 * @description: map控制层
 * @author: zgr
 * @create: 2019-07-01 14:43
 **/
@Slf4j
@RestController
@RequestMapping("/dim/element/basic")

public class MapController {
    @Value("${geometryType:POINT}")
    private String geometryType;

    @Autowired
    private MapService mapService;

    /**
     * @param mapElement 元素
     * @return list类型的mapElement
     */
    @GetMapping()
    public List<MapElement> findAll(MapElement mapElement){
        List<MapElement> mapElementList =  mapService.findAll();

        try {
            for(int i = 0; i < mapElementList.size(); i++) {
                double[] longitudeAndLatitude = getLonAndLat(mapElementList.get(i));
                mapElementList.get(i).setLongitude(longitudeAndLatitude[0]);
                mapElementList.get(i).setLatitude(longitudeAndLatitude[1]);
            }
        }catch (Exception e){
            log.info("错误信息："+ e);
        }
        return mapElementList;
    }

    /**
     * @param longitude 经度
     * @param latitude 维度
     * @param type 元素大类
     * @param subType 元素细分类
     * @param radius 区域半径，单位为km
     * @return 以给定点为原型，radis为半径的区域中满足条件的元素的集合
     */
    @GetMapping("/spatial/circle")
    public List<MapElement> findMapElementByCircle(Long longitude, Long latitude, String type, String subType, double radius){


        return null;
    }

    /**
     * @param mapElement
     * @return 添加的map信息
     */
    @PostMapping()
    public MapElement addMapElement(@RequestBody MapElement mapElement){
        String geoString = getGeometryText(mapElement);
        mapElement.setGeoStr(geoString);

        mapService.addMapElement(mapElement);
        Long id = mapElement.getId();
        MapElement mapElementResult =  mapService.findById(id);
        double[] longitudeAndLatitude = getLonAndLat(mapElementResult);
        mapElementResult.setLongitude(longitudeAndLatitude[0]);
        mapElementResult.setLatitude(longitudeAndLatitude[1]);

        return mapElementResult;
    }

    @PutMapping()
    public MapElement updateMapElement(@RequestBody MapElement mapElement){
        String geoString = getGeometryText(mapElement);
        mapElement.setGeoStr(geoString);

        mapService.updateMapElement(mapElement);
        Long id = mapElement.getId();
        MapElement mapElementResult =  mapService.findById(id);
        double[] longitudeAndLatitude = getLonAndLat(mapElementResult);
        mapElementResult.setLongitude(longitudeAndLatitude[0]);
        mapElementResult.setLatitude(longitudeAndLatitude[1]);

        return mapElementResult;
    }

    /**
     * @param id id
     * @return 是否删除成功
     */
    @DeleteMapping("/{id}")
    public Boolean deleteMapElement(@PathVariable Long id){
        Boolean deleteMapElementSuccess = true;
        try{
            mapService.deleteMapElement(id);
        }catch (Exception e){
            log.info("删除失败：" + e);
            deleteMapElementSuccess = false;
        }
        return deleteMapElementSuccess;
    }


    /**
     * @param mapElement
     * @return 包含经纬度的长度为2的一维数组
     */
    private double[] getLonAndLat(MapElement mapElement){
        double[] longitudeAndLatitude = new double[2];
        try{
            JSONObject point = JSONObject.fromObject(mapElement.getGeoStr());
            JSONArray coordinate = point.getJSONArray("coordinates");
            //longitude  经度
            //latitude 维度
            longitudeAndLatitude[0] = (double) coordinate.get(0);
            longitudeAndLatitude[1] = (double) coordinate.get(1);

        }catch (Exception e){
            log.info("错误信息：" + e);

        }
        return longitudeAndLatitude;
    }

    /**
     * @param mapElement
     * @return 由经纬度组成的地理信息
     */
    private String getGeometryText(MapElement mapElement){
        double latitude = mapElement.getLatitude();
        double longitude = mapElement.getLongitude();
        String geoString = geometryType + "(" + longitude + " " + latitude + ")";
        return geoString;

    }


}
