package com.allen.controller;

import com.allen.pojo.Depot;
import com.allen.pojo.Truck;
import com.allen.service.DepotTruckManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Allen
 * @date 2021/6/7 16:58
 */

@Controller
@RequestMapping(path = "/depotTruckManage", method={RequestMethod.POST,RequestMethod.GET})
public class DepotTruckManageController {

    @Autowired
    DepotTruckManageService service;

    @ResponseBody
    @GetMapping("/allTruck")
    public List<Truck> allTruck(){
        return service.allTruck();
    }

    @ResponseBody
    @GetMapping("/allDepot")
    public List<Depot> allDepot(){
        return service.allDepot();
    }

    //这里前端使用form-data格式提交数据，注意字段名要一致
    @PostMapping("/updateOilDepotByTruckNums")
    public String updateOilDepotByTruckNums(@RequestParam("truck_nums") String truck_nums,
                                            @RequestParam("oil_depot_name") String oil_depot_name){

        Map<String,Object> map = new HashMap<>();
        map.put("oil_depot_name",oil_depot_name);
        map.put("truck_nums",truck_nums);

        service.updateOilDepotByTruckNums(map);
        return "redirect:/depotTruckManage/allTruck";
    }

    @ResponseBody
    @GetMapping("/allAssignedTrucks")
    public Map<String, List<String>> allAssignedTrucks(){
        return service.allAssignedTrucks();
    }

}
