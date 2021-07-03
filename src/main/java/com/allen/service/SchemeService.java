package com.allen.service;

import com.allen.pojo.StationAssignDetail;
import com.allen.pojo.TruckTripDetail;
import com.mathworks.toolbox.javabuilder.MWCharArray;
import com.mathworks.toolbox.javabuilder.MWException;

import java.util.List;

/**
 * @author Allen
 * @date 2021/3/13 19:34
 */
public interface SchemeService {

    //调用算法计算，结果存储到数据库
    void callAlgorithm(MWCharArray oil_depot_no, MWCharArray order_date) throws MWException;

    //查询所有车辆的行程数
    List<TruckTripDetail> allTruckTrip(int pageNum, int pageSize);

    //查询某辆车的行程详情
    List<TruckTripDetail> truckTripDetail(String truck_num,int pageNum, int pageSize);

    //查询所有加油站订单分配详情
    List<StationAssignDetail> allStationOrder(int pageNum, int pageSize);

    //查询某一加油站订单配送详情
    List<StationAssignDetail> stationOrderDetail(String oil_station_id, int pageNum, int pageSize);

    //查询结果生成时间
    String queryResultTime();

    // 和收益
    Double queryResultRevenue();
}
