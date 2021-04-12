package com.honorzhang.enumdemo.ctrl;

import com.honorzhang.enumdemo.move.LaterallyActionDTO;
import com.honorzhang.enumdemo.move.RotateActionDTO;
import com.honorzhang.enumdemo.move.StraightActionDTO;
import com.honorzhang.enumdemo.move.VerticalActionDTO;
import com.honorzhang.enumdemo.vo.MovementControlVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @program: enum-demo
 * @author: zgr
 * @create: 2020-04-10 14:23
 **/
@Slf4j
@RestController
@RequestMapping("/enum/demo")
public class EnumController {
    @GetMapping("/manual/control")
    public ResponseEntity<MovementControlVO> controlByManual() {
        MovementControlVO movementControlVO = new MovementControlVO();
        StraightActionDTO straightActionDTO = StraightActionDTO.STOP;
        LaterallyActionDTO laterallyActionDTO = LaterallyActionDTO.RIGHT;
        RotateActionDTO rotateActionDTO = RotateActionDTO.RIGHT;
        VerticalActionDTO verticalActionDTO = VerticalActionDTO.DOWN;

        movementControlVO.setLaterallyAction(laterallyActionDTO);
        movementControlVO.setRollAction(rotateActionDTO);
        movementControlVO.setStraightAction(straightActionDTO);
        movementControlVO.setVerticalAction(verticalActionDTO);


        return ResponseEntity.ok().body(movementControlVO);
    }


    @PostMapping("/manual/control")
    public ResponseEntity<MovementControlVO> controlByManu(@RequestBody MovementControlVO vo) {

        MovementControlVO vos = vo;
        String name = vo.getStraightAction().name();

        return ResponseEntity.ok().body(vos);
    }

}
