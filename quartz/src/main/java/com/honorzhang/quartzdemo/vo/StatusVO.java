package com.honorzhang.quartzdemo.vo;

/**
 * @program: ump-server
 * @author: zgr
 * @create: 2020-03-31 13:36
 **/
public enum StatusVO {
    /**
     * 航点
     */
    wayPointIrrationality("07", "航点设置不合理"),

    /**
     * 环境校验
     */
    environmentVerificationInconformity("08", "环境校验不通过"),

    /**
     * 电池电量
     */
    BatteryVoltageLow("09", "电池电量低"),

    /**
     *飞机解锁
     */
    UavUnlocked("10", "飞机解锁失败，请检查网络状态与飞机状态"),

    /**
     * 任务执行完成
     */
    taskCompleted("0", "本次飞行任务完成"),

    /**
     *机舱异常情况之左舱门打开故障
     */
    leftGateOpenFault("11", "左舱门打开故障"),

    /**
     *机舱异常情况之左舱门关闭故障
     */
    leftGateCloseFault("11", "左舱门关闭故障"),

    /**
     *机舱异常情况之右舱门打开故障
     */
    rightGateOpenFault("11", "右舱门打开故障"),

    /**
     *机舱异常情况之右舱门关闭故障
     */
    rightGateCloseFault("11", "右舱门关闭故障"),

    /**
     *机舱异常情况之升降机构上升故障
     */
    UpDownStructureUpFault("11", "升降机构上升故障"),

    /**
     *机舱异常情况之升降机构下降故障
     */
    UpDownStructureDownFault("11", "升降机构下降故障"),

    /**
     *机舱异常情况之水平推杆推进故障
     */
    levelPushRodPushFault("11", "水平推杆推进故障"),

    /**
     *机舱异常情况之水平推杆收藏故障
     */
    levelPushRodStoreFault("11", "水平推杆收藏故障"),

    /**
     * 机舱异常情况之垂直推杆1推进故障
     */
    verticalPushRodOnePushFault("11", "垂直推杆1推进故障"),

    /**
     *机舱异常情况之垂直推杆2推进故障
     */
    verticalPushRodTwoPushFault("11", "垂直推杆2推进故障"),

    /**
     * 机舱异常情况之垂直推杆1收藏故障
     */
    verticalPushRodOneStoreFault("11", "垂直推杆1收藏故障"),

    /**
     *机舱异常情况之垂直推杆2收藏故障
     */
    verticalPushRodTwoStoreFault("11", "垂直推杆2收藏故障"),

    /**
     * 机舱异常情况之1号舵机抬起故障
     */
    steeringEngineOneUpFault("11", "1号舵机抬起故障"),

    /**
     *机舱异常情况之2号舵机抬起故障
     */
    steeringEngineTwoUpFault("11", "2号舵机抬起故障"),

    /**
     * 机舱异常情况之1号舵机下降故障
     */
    steeringEngineOneDownFault("11", "1号舵机下降故障"),

    /**
     *机舱异常情况之2号舵机下降故障
     */
    steeringEngineTwoDownFault("11", "2号舵机下降故障");





    ;
    private String code;
    private String message;

    StatusVO(String code, String message){
        this.code = code;
        this.message = message;
    }
}
