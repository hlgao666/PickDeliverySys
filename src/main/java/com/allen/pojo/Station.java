package com.allen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Allen
 * @date 2021/3/13 21:44
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Station  implements Serializable {
    //加油站id
    private String oil_station_id;

    //加油站名称
    private String station;

    //经度
    private Double longitude;

    //纬度
    private Double latitude;

}
