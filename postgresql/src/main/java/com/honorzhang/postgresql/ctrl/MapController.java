package com.honorzhang.postgresql.ctrl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.honorzhang.postgresql.model.MapElement;
import com.honorzhang.postgresql.model.vo.MapElementPageModel;
import com.honorzhang.postgresql.service.MapService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: postgresql
 * @description: map控制层
 * @author: zgr
 * @create: 2019-07-01 14:43
 **/
@Slf4j
@RestController
@RequestMapping("/postgis/test")

public class MapController {

    @Autowired
    private MapService mapService;

    /**
     * 添加地图元素
     * @param mapElement
     * @return 添加的地理元素信息
     */
    @PostMapping
    public MapElement addMapElement(@RequestBody MapElement mapElement){
        mapElement.setGeoStr(geometryToString(mapElement.getLongitude(), mapElement.getLatitude()));
        mapService.addMapElement(mapElement);
        Long id = mapElement.getId();
        return mapService.findById(id);
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
     * 数据更改
     * @param mapElement
     * @return 更改后的数据
     */
    @PutMapping()
    public MapElement updateMapElement(@RequestBody MapElement mapElement){
        mapElement.setGeoStr(geometryToString(mapElement.getLongitude(), mapElement.getLatitude()));
        mapService.updateMapElement(mapElement);
        Long id = mapElement.getId();
        return mapService.findById(id);
    }

    /**
     * 查询全部信息
     * @return
     */
    @GetMapping("/list")
    public List<MapElement> findAll(){
        return mapService.findAll();
    }

    /**
     * 条件查找
     * @param mapElement
     * @return 复合条件的地图元素
     */
    @GetMapping("/condition")
    public List<MapElement> findMapElementByCondition(MapElement mapElement){
        return mapService.findMapElementByCondition(mapElement);
    }

    /**
     * 分页查找
     * @param currentPage 当前在第几页
     * @param pageSize 每页数据条数
     * @return 带PageInfo信息的返回结果
     */
    @GetMapping
    public PageInfo<MapElement> findMapElementByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<MapElement> list = mapService.findAll();
        return new PageInfo<>(list);
    }

    /**
     * 圆形区域查找
     * @param longitude 圆形区域圆心之经度
     * @param latitude 圆形区域圆心之纬度
     * @param radius 区域半径，单位为km
     * @return 以给定点为原型，radis为半径的区域中满足条件的元素的集合
     */
    @GetMapping("/circle")
    public List<MapElement> findByMapElementCircle(double longitude, double latitude, double radius){
        String geometry = "(" + longitude + " " + latitude + ")";
        //单位转换
        double radiusMeter = radius * 1000;
        return mapService.findMapElementByCircle(geometry, radiusMeter);
    }

    /**
     * 多边形区域查找
     * @param geometry 多边形参数
     * @return 满足条件的结果
     */
    @GetMapping("/polygon")
    public List<MapElement> findByMapElementPolygon(String geometry){
        return mapService.findMapElementByPolygon(geometry);
    }

    @PostMapping("/testInsert")
    public String addTest(){
        Map<String,Object> map = new HashMap<>();
        List<MapElementPageModel> mapElementPageModelList = new ArrayList<>();
        for(int i = 0; i<10; i++){
            MapElementPageModel mapElementPageModel = new MapElementPageModel();
            mapElementPageModel.setFireTeamId(1L);
            mapElementPageModel.setFireTeamPeopleId((long) i);
            mapElementPageModelList.add(mapElementPageModel);
        }
        map.put("testList",mapElementPageModelList );
        mapService.addTest(map);
        return "hahahhahahahahahhahah";
    }



    private String geometryToString(double longitude, double latitude){
        String geoStr = "POINT" + "(" + longitude + " " + latitude + ")";
        return geoStr;
    }


}
