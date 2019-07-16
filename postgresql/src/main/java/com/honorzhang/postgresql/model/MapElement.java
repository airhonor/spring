package com.honorzhang.postgresql.model;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: postgresql
 * @author: zgr
 * @create: 2019-07-01 14:35
 **/
@Data
public class MapElement {

    /**
     * 数据库自增主键
     */
    private Long id;

    /**
     * 地图元素的名称（医院，银行，警察局等）
     */
    private String name;


     //地图元素（医院，银行，警察局）以点的形式存储
    /**
     * 地图元素位置点的的纬度
     */
    private Double latitude;

    /**
     * 地图元素位置点的经度
     */
    private Double longitude;

    /**
     * 空间信息转换为字符串
     */
    private String geoStr;
}
