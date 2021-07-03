package com.allen.service.Impl;

import com.allen.mapper.DepotTruckManageMapper;
import com.allen.pojo.Depot;
import com.allen.pojo.Truck;
import com.allen.service.DepotTruckManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Allen
 * @date 2021/6/7 16:47
 */

@Service
public class DepotTruckManageServiceImpl implements DepotTruckManageService {

    @Autowired
    DepotTruckManageMapper mapper;

    @Override
    public List<Truck> allTruck() {
        return mapper.allTruck();
    }

    @Override
    public List<Depot> allDepot() {
        return mapper.allDepot();
    }

    @Override
    public void updateOilDepotByTruckNums(Map<String,Object> map) {
        mapper.updateOilDepotByTruckNums(map);
    }

    @Override
    public Map<String, List<String>> allAssignedTrucks() {
        List<String> oil_depot_nos = mapper.allAssignedDepot();
        Map<String, List<String>> map = new HashMap<>();
        for (String oil_depot_no : oil_depot_nos) {
            List<String> list = mapper.allTruckByDepot(oil_depot_no);
            map.put(oil_depot_no,list);
        }
        return map;
    }
}
