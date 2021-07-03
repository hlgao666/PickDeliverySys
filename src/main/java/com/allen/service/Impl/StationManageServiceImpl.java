package com.allen.service.Impl;

import com.allen.mapper.StationManageMapper;
import com.allen.pojo.OilCan;
import com.allen.pojo.Station;
import com.allen.pojo.StationDistance;
import com.allen.service.StationManageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Allen
 * @date 2021/6/7 22:53
 */

@Service
public class StationManageServiceImpl implements StationManageService {

    @Autowired
    StationManageMapper mapper;

    @Override
    public void addStationPosition(Station station) {
        mapper.addStationPosition(station);
    }

    @Override
    public void deleteStationPosition(String oil_station_id) {
        mapper.deleteStationPosition(oil_station_id);
    }

    @Override
    public void updateStationPosition(Station station) {
        mapper.updateStationPosition(station);
    }

    @Override
    public Station queryStationById(String oil_station_id) {
        return mapper.queryStationById(oil_station_id);
    }

    @Override
    public List<Station> allStationPosition(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Station> lists = mapper.allStationPosition();
        PageInfo<Station> pi = new PageInfo<>(lists);
        return pi.getList();
    }

    ///////////////////////////////////////////////////////////////////////

    @Override
    public void addDistance(StationDistance stationDistance) {
        mapper.addDistance(stationDistance);
    }

    @Override
    public void deleteDistance(StationDistance stationDistance) {
        mapper.deleteDistance(stationDistance);
    }

    @Override
    public void updateDistance(StationDistance stationDistance) {
        mapper.updateDistance(stationDistance);
    }

    @Override
    public StationDistance queryByIds(String oil_station_id1, String oil_station_id2) {
        return mapper.queryByIds(oil_station_id1,oil_station_id2);
    }

    @Override
    public List<StationDistance> allDistance(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<StationDistance> lists = mapper.allDistance();
        PageInfo<StationDistance> pi = new PageInfo<>(lists);
        return pi.getList();
    }

    ///////////////////////////////////////////////////////////////////////////////////


    @Override
    public void addOilCan(OilCan oilCan) {
        mapper.addOilCan(oilCan);
    }

    @Override
    public void deleteOilCan(String oil_station_id, String pot_no) {
        mapper.deleteOilCan(oil_station_id,pot_no);
    }

    @Override
    public void updateOilCan(OilCan oilCan) {
        mapper.updateOilCan(oilCan);
    }

    @Override
    public List<OilCan> queryByDepot(String oil_depot_no,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<OilCan> lists = mapper.queryByDepot(oil_depot_no);
        PageInfo<OilCan> pi = new PageInfo<>(lists);
        return pi.getList();
    }

    @Override
    public List<OilCan> allOilCan(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<OilCan> lists = mapper.allOilCan();
        PageInfo<OilCan> pi = new PageInfo<>(lists);
        return pi.getList();
    }
}
