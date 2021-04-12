package com.honorzhang.enumdemo.vo;


import com.honorzhang.enumdemo.move.LaterallyActionDTO;
import com.honorzhang.enumdemo.move.RotateActionDTO;
import com.honorzhang.enumdemo.move.StraightActionDTO;
import com.honorzhang.enumdemo.move.VerticalActionDTO;
import lombok.Data;

/**
 * @author zhaoe
 */
@Data
public class MovementControlVO {

    /**
     * 前后移动
     */
    private StraightActionDTO straightAction;
    /**
     * 左右移动
     */
    private LaterallyActionDTO laterallyAction;
    /**
     * 上下移动
     */
    private VerticalActionDTO verticalAction;

    /**
     * 左右旋转
     */
    private RotateActionDTO rollAction;
}
