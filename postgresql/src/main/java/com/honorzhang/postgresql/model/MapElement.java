package com.honorzhang.postgresql.model;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: postgresql
 * @description: map实体
 * @author: zgr
 * @create: 2019-07-01 14:35
 **/
@Data
public class MapElement {

    private Long id;

    private String name;

    /**
     * 身份唯一标识
     */
    private String uniqueCode;

    private String type;

    private double latitude;

    private double longitude;

    private String subType;

    private String remark;

    private BigDecimal price;

    private String geoStr;
}
