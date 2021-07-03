package com.allen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Allen
 * @date 2021/6/7 21:35
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StationDistance  implements Serializable {

    //加油站1id
    private String oil_station_id1;

    //加油站2id
    private String oil_station_id2;

    //距离
    private Double distance;

    //状态  是否可用 0 可用  1不可用  默认 0
    private String status;
}
