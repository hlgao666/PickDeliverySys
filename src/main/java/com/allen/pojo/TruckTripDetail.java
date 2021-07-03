package com.allen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Allen
 * @date 2021/3/13 16:03
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TruckTripDetail implements Serializable {

    //订单日期
    private String order_date;

    //车牌号
    private String truck_num;

    //行程序号
    private int trip_no;

    //行程总数
    private int trip_total;

    //加油站id
    private String oil_station_id;

    //加油站名称
    private String station;

    //订单id
    private String order_id;

    //油品类型
    private String oil_type;

    //需求量
    private int requirement;

    //车舱号
    private int comp_no;

    //行程开始时刻
    private String trip_begin_time;

    //到达时刻
    private String arrive_time;

    //行程结束时刻
    private String turns_end_time;
}
