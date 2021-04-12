package com.honorzhang.enumdemo.move;

/**
 * @author zhaoe
 */

public enum RotateActionDTO {
    /**
     * 停止
     */
    STOP("STOP"),
    /**
     * 右转
     */
    RIGHT("RIGHT"),
    /**
     * 左转
     */
    LEFT("LEFT");
    private String desc;

    RotateActionDTO(String desc) {
        this.desc=desc;
    }
}
