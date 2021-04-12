package com.honorzhang.postgresql.model.vo;

import lombok.Data;

/**
 * @program: postgresql
 * @author: zgr
 * @create: 2019-08-12 16:34
 **/
@Data
public class MapElementPageModel {
    /**
     * 扑火队id
     */
    private Long fireTeamId;

    /**
     * 扑火队对应人员id
     */
    private Long fireTeamPeopleId;
}
