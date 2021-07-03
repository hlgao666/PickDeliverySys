package com.allen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.io.Serializable;

/**
 * @author Allen
 * @date 2021/3/13 21:43
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order  implements Serializable {
    //订单日期
    private String order_date;
    //订单id
    private String order_id;
    //加油站
    private String station;
    //加油站id
    private String oil_station_id;
    //所属油库
    private String oil_depot_no;
    //罐号
    private String pot_no;
    //油品类型
    private String oil_type;
    //需求量
    private int requirement;
    //订单优先级
    private int priority;
    //订单断供时刻
    private String off_for;
    //订单状态
    //0:待配送；1：已配送；2：紧急下发
    private int status;
}
