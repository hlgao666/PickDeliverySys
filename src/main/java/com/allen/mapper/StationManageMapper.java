package com.allen.mapper;

import com.allen.pojo.OilCan;
import com.allen.pojo.Station;
import com.allen.pojo.StationDistance;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Allen
 * @date 2021/6/7 21:08
 */

@Mapper
@Repository
public interface StationManageMapper {

    /**
     * 添加油站位置
     * @author allen
     * @date 2021/6/7 21:24
     * @param station
     */
    void addStationPosition(Station station);


    /**
     * 删除油库位置
     * @author allen
     * @date 2021/6/7 21:30
     * @param oil_station_id
     */
    void deleteStationPosition(String oil_station_id);


    /**
     * 修改油库位置
     * @author allen
     * @date 2021/6/7 21:31
     * @param station
     */
    void updateStationPosition(Station station);


    /**
     * 根据加油站id查找位置
     * @author allen
     * @date 2021/6/7 21:32
     * @param oil_station_id
     * @return com.allen.pojo.Station
     */
    Station queryStationById(String oil_station_id);


    /**
     * 查找所有加油站位置
     * @author allen
     * @date 2021/6/7 21:33
     * @return java.util.List<com.allen.pojo.Station>
     */
    List<Station> allStationPosition();

    //////////////////////////////////////////////////////////////////////////////////

    /**
     * 添加加油站距离
     * @author allen
     * @date 2021/6/7 21:39
     * @param stationDistance
     */
    void addDistance(StationDistance stationDistance);


    /**
     * 删除加油站距离
     * @author allen
     * @date 2021/6/7 21:40
     * @param stationDistance
     */
    void deleteDistance(StationDistance stationDistance);


    /**
     * 修改加油站距离
     * @author allen
     * @date 2021/6/7 21:41
     * @param stationDistance
     */
    void updateDistance(StationDistance stationDistance);


    /**
     * 根据两个加油站id查找距离
     * @author allen
     * @date 2021/6/7 21:43
     * @param oil_station_id1
     * @param oil_station_id2
     * @return com.allen.pojo.StationDistance
     */
    StationDistance queryByIds(String oil_station_id1, String oil_station_id2);


    /**
     * 查找所有距离
     * @author allen
     * @date 2021/6/7 21:44
     * @return java.util.List<com.allen.pojo.StationDistance>
     */
    List<StationDistance> allDistance();

    //////////////////////////////////////////////////////////////////////////////////

    /**
     * 添加油罐
     * @author allen
     * @date 2021/6/7 21:46
     * @param oilCan
     */
    void addOilCan(OilCan oilCan);


    /**
     * 根据加油站id和油罐编号 删除油罐
     * @author allen
     * @date 2021/6/7 21:47
     * @param oil_station_id
     * @param pot_no
     */
    void deleteOilCan(String oil_station_id, String pot_no);


    /**
     * 修改油罐
     * @author allen
     * @date 2021/6/7 21:48
     * @param oilCan
     */
    void updateOilCan(OilCan oilCan);


    /**
     * 根据油库编号查找所有加油站的油罐
     * @author allen
     * @date 2021/6/7 21:50
     * @param oil_depot_no
     * @return java.util.List<com.allen.pojo.OilCan>
     */
    List<OilCan> queryByDepot(String oil_depot_no);


    /**
     * 查找所有油罐
     * @author allen
     * @date 2021/6/7 21:52
     * @return java.util.List<com.allen.pojo.OilCan>
     */
    List<OilCan> allOilCan();

}
