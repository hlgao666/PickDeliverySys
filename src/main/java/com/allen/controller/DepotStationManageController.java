package com.allen.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.allen.service.DepotStationManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author Allen
 * @date 2021/6/8 13:00
 */

@Controller
@RequestMapping(path = "/depotStationManage", method={RequestMethod.POST,RequestMethod.GET})
public class DepotStationManageController {

    @Autowired
    DepotStationManageService service;

    @ResponseBody
    @GetMapping("/allDepot")
    public List<String> allDepot(){
        return service.allDepot();
    }


    @ResponseBody
    @GetMapping("/allStation")
    public List<String> allStation(){
        return service.allStation();
    }


    //这里前端使用form-data格式提交数据，注意字段名要一致
    @PostMapping("/updateOilDepotByStations")
    public String updateOilDepotByStations(@RequestParam List<String> stations,
                                           @RequestParam("oil_depot_name") String oil_depot_name){


        Map<String,Object> map = new HashMap<>();
        map.put("oil_depot_name", oil_depot_name);
        map.put("stations",stations);

        service.updateOilDepotByStations(map);
        return "redirect:/depotStationManage/allStation";
    }


    @ResponseBody
    @GetMapping("/allAssignedStations")
    public Map<String, List<String>> allAssignedStations(){
        return  service.allAssignedStations();
    }

}
