package com.allen.service.Impl;

import com.allen.mapper.SelectTruckMapper;
import com.allen.pojo.Truck;
import com.allen.service.SelectTruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Allen
 * @date 2021/3/16 15:52
 */

@Service
public class SelectTruckServiceImpl implements SelectTruckService {

    @Autowired
    SelectTruckMapper selectTruckMapper;

    @Override
    public List<Truck> showCandidateTruckByDepot(String oil_depot_no) {
        return selectTruckMapper.showCandidateTruckByDepot(oil_depot_no);
    }

    @Override
    public void selectUsableTruck(List<String> truck_num_set) {
        selectTruckMapper.selectUsableTruck(truck_num_set);
    }



//
//    @Override
//    public void selectAllTruckByDepot(String oil_depot_no) {
//        selectTruckMapper.selectAllTruckByDepot(oil_depot_no);
//    }
//
//
//    @Override
//    public void removeSingleTruck(String truck_num) {
//        selectTruckMapper.removeSingleTruck(truck_num);
//    }
//
//
//    @Override
//    public void updateTruck(Truck truck) {
//        selectTruckMapper.updateTruck(truck);
//        selectTruckMapper.updateCandidateTruck(truck);
//    }
//
//
    @Override
    public List<Truck> queryAllSelectedTruck() {
        return selectTruckMapper.queryAllSelectedTruck();
    }
//
//
    @Override
    public void truncateTable() {
        selectTruckMapper.truncateTable();
    }
}
