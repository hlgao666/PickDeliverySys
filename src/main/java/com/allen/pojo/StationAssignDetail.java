package com.allen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Allen
 * @date 2021/3/13 19:55
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StationAssignDetail  implements Serializable {

    //订单日期
    private String order_date;

    //加油站id
    private String oil_station_id;

    //加油站名称
    private String station;

    //油库名称
    private String oil_depot_name;

    //订单总数
    private int order_total;

    //订单id
    private String order_id;

    //油品类型
    private String oil_type;

    //需求量
    private int requirement;

    //罐号
    private int pot_no;

    //车牌号
    private String truck_num;

    //行程开始时刻
    private String trip_begin_time;

    //到达时刻
    private String arrive_time;

}
