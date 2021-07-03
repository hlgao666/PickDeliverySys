package com.allen.service;

import com.allen.pojo.Truck;

import java.util.List;

/**
 * @author Allen
 * @date 2021/3/16 15:51
 */
public interface SelectTruckService {


    /*
     * 展示左侧的待选车辆，根据油库选择出要展示的待选车辆
     * @author allen
     * @date 2021/5/24 10:56
     * @param oil_depot_no
     */
    List<Truck> showCandidateTruckByDepot(String oil_depot_no);


    /*
     * 根据油库选择车辆。从表 candidate_truck 到表 logistics_usable_truck
     * @author allen
     * @date 2021/5/24 10:58
     * @param truck_num_set 车牌号集合
     */
    void selectUsableTruck(List<String> truck_num_set);


//    //根据油库选择车辆。从表 candidate_truck 到表 logistics_usable_truck
//    void selectAllTruckByDepot(String oil_depot_no);
//
//
//    //移除。仅移除logistics_usable_truck表的可用车辆
//    void removeSingleTruck(String truck_num);
//
//
//    //修改。修改两张表
//    //只允许修改：
//    /**
//     * 1.车辆类型
//     * 2.所属油库
//     *
//     * @param truck
//     */
//    void updateTruck(Truck truck);
//
//
//    //查询所有选中的车辆
    List<Truck> queryAllSelectedTruck();
//
//
//    //清空 logistics_usable_truck表
    void truncateTable();
}
