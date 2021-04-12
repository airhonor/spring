package com.honorzhang.enumdemo.move;
/**
 * @author zhaoe
 */
public enum VerticalActionDTO {
    /**
     * 停止
     */
    STOP("STOP"),
    /**
     * 下降
     */
    DOWN("DOWN"),
    /**
     * 上升
     */
    UP("UP");
    private String desc;

    VerticalActionDTO(String desc) {
        this.desc=desc;
    }
}
