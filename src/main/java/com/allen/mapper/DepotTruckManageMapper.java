package com.allen.mapper;

import com.allen.pojo.Depot;
import com.allen.pojo.Truck;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Allen
 * @date 2021/6/6 22:55
 */

@Mapper
@Repository
public interface DepotTruckManageMapper {

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
     * @date 2021/6/6 23:05
     */
    void updateOilDepotByTruckNums(Map<String,Object> map);

    /**
     * 按油库编号，返回所有已分配的油库编号集合
     * @author allen
     * @date 2021/6/7 15:11
     * @return java.util.Map<java.lang.String,java.util.List<java.lang.String>>
     */
    List<String> allAssignedDepot();

    /**
     * 返回分配给某一油库的车辆集合
     * @author allen
     * @date 2021/6/7 16:40
     * @param oil_depot_no
     * @return java.util.List<java.lang.String>
     */
    List<String> allTruckByDepot(String oil_depot_no);

}
