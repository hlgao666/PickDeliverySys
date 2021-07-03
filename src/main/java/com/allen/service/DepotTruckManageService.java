package com.allen.service;

import com.allen.pojo.Depot;
import com.allen.pojo.Truck;

import java.util.List;
import java.util.Map;

/**
 * @author Allen
 * @date 2021/6/7 16:37
 */
public interface DepotTruckManageService {

    /**
     * 查询所有车辆
     * @author allen
     * @date 2021/6/6 23:02
     * @return java.util.List<com.allen.pojo.Truck>
     */
    List<Truck> allTruck();

    /**
     * 查询所有油库名称
     * @author allen
     * @date 2021/6/6 23:07
     * @return java.util.List<com.allen.pojo.Depot>
     */
    List<Depot> allDepot();

    /**
     * 根据车牌号集合修改所属油库，提交后自动重定向到 allTruck
     * @author allen
     * @date 2021/6/7 20:13
     */
    void updateOilDepotByTruckNums(Map<String,Object> map);

    /**
     * 按油库编号，返回所有已分配的车辆集合
     * @author allen
     * @date 2021/6/7 15:11
     * @return java.util.Map<java.lang.String,java.util.List<java.lang.String>>
     */
    Map<String, List<String>> allAssignedTrucks();
}
