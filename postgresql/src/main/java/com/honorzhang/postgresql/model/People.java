package com.honorzhang.postgresql.model;

import lombok.Data;


/**
 * @author ：zgr
 * @date ：Created in 2019/6/10
 */
@Data
public class People {

    private Long id;

    private String name;

    /**
     * 身份唯一标识
     */
    private String uniqueCode;

    /**
     * 最新位置经度
     */
    private Double lastLon;

    /**
     * 最新位置纬度
     */
    private Double lastLat;

    /**
     * 是否在线
     */
    private Boolean online;
}
