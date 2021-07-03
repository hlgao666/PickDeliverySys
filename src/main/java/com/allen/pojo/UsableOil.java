package com.allen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Allen
 * @date 2021/5/22 17:54
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsableOil  implements Serializable {

    //油库编号
    private String oil_depot_no;

    //油罐编号
    private String oil_pot_no;

    //油品类型
    private String oil_type_id;

    //油品密度
    private BigDecimal oil_density;

    //测量时间
    private String measure_time;

    //是否可用
    //0：不可用；1：可用
    private int state;

    //可发数量
    private String usable_vol;
}
