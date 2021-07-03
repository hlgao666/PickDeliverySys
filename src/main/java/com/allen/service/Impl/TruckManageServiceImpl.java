package com.allen.service.Impl;

import com.allen.mapper.TruckManageMapper;
import com.allen.pojo.Truck;
import com.allen.service.TruckManageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Allen
 * @date 2021/6/6 22:34
 */
@Service
public class TruckManageServiceImpl implements TruckManageService {

    @Autowired
    TruckManageMapper mapper;


    @Override
    public List<Truck> allTruck(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Truck> lists = mapper.allTruck();
        PageInfo<Truck> pi = new PageInfo<>(lists);
        return pi.getList();
    }

    @Override
    public List<Truck> queryTruckByTruckNum(String truck_num,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Truck> lists = mapper.queryTruckByTruckNum(truck_num);
        PageInfo<Truck> pi = new PageInfo<>(lists);
        return pi.getList();
    }

    @Override
    public void addTruck(Truck truck) {
        mapper.addTruck(truck);
    }

    @Override
    public void updateTruck(Truck truck) {
        mapper.updateTruck(truck);
    }

    @Override
    public void deleteTruckByTruckNum(String truck_num) {
        mapper.deleteTruckByTruckNum(truck_num);
    }

    @Override
    public List<String> queryTruckNum(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<String> lists = mapper.queryTruckNum();
        PageInfo<String> pi = new PageInfo<>(lists);
        return pi.getList();
    }
}
