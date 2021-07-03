package com.allen.service;

import com.allen.pojo.Truck;

import java.util.List;

/**
 * @author Allen
 * @date 2021/6/6 22:34
 */
public interface TruckManageService {

    /**
     * 查询全部车辆信息
     * @author allen
     * @date 2021/6/6 22:06
     * @return java.util.List<com.allen.pojo.Truck>
     */
    List<Truck> allTruck(int pageNum, int pageSize);

    /**
     * 根据车牌号查询车辆信息
     * @author allen
     * @date 2021/6/6 22:08
     * @param truck_num
     * @return com.allen.pojo.Truck
     */
    List<Truck> queryTruckByTruckNum(String truck_num,int pageNum, int pageSize);

    /**
     * 添加单个车辆
     * @author allen
     * @date 2021/6/6 22:10
     * @param truck
     */
    void addTruck(Truck truck);

    /**
     * 修改单个车辆信息
     * @author allen
     * @date 2021/6/6 22:11
     * @param truck
     */
    void updateTruck(Truck truck);

    /**
     * 根据车牌号删除车辆
     * @author allen
     * @date 2021/6/6 22:12
     * @param truck_num
     */
    void deleteTruckByTruckNum(String truck_num);

    List<String> queryTruckNum(int pageNum, int pageSize);
}
