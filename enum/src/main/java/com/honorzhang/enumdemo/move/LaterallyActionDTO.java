package com.honorzhang.enumdemo.move;

/**
 * @author zhaoe
 */
public enum LaterallyActionDTO {
    /**
     * 停止
     */
    STOP("STOP"),
    /**
     * 右移
     */
    RIGHT("RIGHT"),
    /**
     * 左移
     */
    LEFT("LEFT");
    private String desc;

    LaterallyActionDTO(String desc) {
        this.desc = desc;
    }
}
