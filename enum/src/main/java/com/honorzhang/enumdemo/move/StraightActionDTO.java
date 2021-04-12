package com.honorzhang.enumdemo.move;

/**
 * @author zhaoe
 */
public enum StraightActionDTO {
    /**
     * 停止
     */
    STOP("STOP"),
    /**
     * 后退
     */
    BACK("BACK"),
    /**
     * 前进
     */
    FORTH("FORTH");
    private String desc;

    StraightActionDTO(String desc) {
        this.desc=desc;
    }
}
