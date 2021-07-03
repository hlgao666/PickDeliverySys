package com.allen.service;

import java.util.List;
import java.util.Map;

/**
 * @author Allen
 * @date 2021/6/8 12:55
 */
public interface DepotStationManageService {

    /**
     * 查询所有油库名称
     * @author allen
     * @date 2021/6/8 11:22
     * @return java.util.List<com.allen.pojo.Depot>
     */
    List<String> allDepot();

    /**
     * 查询所有加油站名称
     * @author allen
     * @date 2021/6/8 11:24
     * @return java.util.List<java.lang.String>
     */
    List<String> allStation();

    /**
     * 根据加油站名称集合修改所属油库，提交后自动重定向到 allStation
     * @author allen
     * @date 2021/6/8 11:26
     * @param map
     */
    void updateOilDepotByStations(Map<String,Object> map);



    /**
     * 按油库编号，返回加油站名称集合
     * @author allen
     * @date 2021/6/8 11:30
     * @return java.util.List<java.lang.String>
     */
    Map<String, List<String>> allAssignedStations();
}
