package com.allen.service.Impl;

import com.allen.mapper.DepotStationManageMapper;
import com.allen.service.DepotStationManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Allen
 * @date 2021/6/8 12:56
 */

@Service
public class DepotStationManageServiceImpl implements DepotStationManageService {

    @Autowired
    DepotStationManageMapper mapper;

    @Override
    public List<String> allDepot() {
        return mapper.allDepot();
    }

    @Override
    public List<String> allStation() {
        return mapper.allStation();
    }

    @Override
    public void updateOilDepotByStations(Map<String, Object> map) {
        mapper.updateOilDepotByStations(map);
    }

    @Override
    public Map<String, List<String>> allAssignedStations() {
        List<String> oil_depot_nos = mapper.allAssignedDepot();
        Map<String, List<String>> map = new HashMap<>();
        for (String oil_depot_no : oil_depot_nos) {
            List<String> list = mapper.allStationByDepot(oil_depot_no);
            map.put(oil_depot_no,list);
        }
        return map;
    }

}
