package com.allen.mapper;

import com.allen.pojo.StationAssignDetail;
import com.allen.pojo.TruckTripDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Allen
 * @date 2021/3/13 15:50
 */

@Mapper
@Repository
public interface SchemeMapper {

    //查询所有车辆的行程统计
    List<TruckTripDetail> allTruckTrip();

    //查询某辆车的行程详情
    List<TruckTripDetail> truckTripDetail(String truck_num);

    //查询所有加油站订单分配详情
    List<StationAssignDetail> allStationOrder();

    //查询某一加油站订单配送详情
    List<StationAssignDetail> stationOrderDetail(String oil_station_id);

    //将生成的结果同步到表result_set中
    void resultCopy();

    //查询方案生成时间
    String queryResultTime();

    //查询方案收益
    Double queryResultRevenue();
}
