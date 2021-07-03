package com.allen.mapper;

import com.allen.pojo.Depot;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Allen
 * @date 2021/6/8 11:21
 */

@Mapper
@Repository
public interface DepotStationManageMapper {

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
     * 返回所有已分配的油库编号集合
     * @author allen
     * @date 2021/6/8 11:29
     * @return java.util.List<java.lang.String>
     */
    List<String> allAssignedDepot();

    /**
     * 返回分配给某一油库的加油站名称集合
     * @author allen
     * @date 2021/6/8 11:30
     * @param oil_depot_name
     * @return java.util.List<java.lang.String>
     */
    List<String> allStationByDepot(String oil_depot_name);

}
