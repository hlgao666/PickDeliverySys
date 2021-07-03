package com.allen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.io.Serializable;

/**
 * @author Allen
 * @date 2021/3/13 21:44
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Depot implements Serializable {

    //油库编号
    private String oil_depot_no;

    //油库名称
    @Nullable
    private String oil_depot_name;

    //经度
    private String longitude;

    //纬度
    private String latitude;
}
