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

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Truck  implements Serializable {
    //车牌号
    private String truck_num;

    //车辆类型
    private String oil_type;

    //车舱类型
    private String bunker_type_id;

    //车舱数
    private int bunker_num;

    //车舱容积
    @Nullable
    private int bunker1_vol;
    @Nullable
    private int bunker2_vol;
    @Nullable
    private int bunker3_vol;
    @Nullable
    private int bunker4_vol;

    //固定成本
    private Double fix_cost;

    //所属油库
    private String oil_depot_no;

    //排班计划
    private String current_plan;

    /**
    //生效时间
    private String begin_time;

    //过期时间
    private String end_time;
     */

    //可用状态
    private boolean status;
}
