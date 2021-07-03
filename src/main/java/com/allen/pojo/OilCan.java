package com.allen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Allen
 * @date 2021/6/7 21:14
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OilCan  implements Serializable {

    //加油站id
    private String oil_station_id;

    //油罐编号
    private String pot_no;

    //油品类型
    private String oil_type;

    //油罐容量
    private Double pot_capacity;

    //目前装油量
    private Double current_oil_loading;

    //测量时间
    private String measure_time;

    //是否自动化测量 0- 是  1-不是
    private String auto_measure;
}
