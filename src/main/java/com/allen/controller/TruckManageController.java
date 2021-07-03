package com.allen.controller;

import com.allen.pojo.Truck;
import com.allen.service.TruckManageService;
import com.allen.util.Contants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Allen
 * @date 2021/6/6 22:37
 */

@Controller
@RequestMapping(path = "/truckManage", method={RequestMethod.POST,RequestMethod.GET})
public class TruckManageController {

    @Autowired
    TruckManageService service;

    @ResponseBody
    @GetMapping("/allTruck")
    public List<Truck> allTruck(@RequestParam(value = "pageNum",defaultValue = Contants.pageNum) int pageNum,
                                @RequestParam(value = "pageSize",defaultValue =Contants.pageSize)int pageSize){
        return service.allTruck(pageNum,pageSize);
    }

    @ResponseBody
    @GetMapping("/queryByNum")
    public List<Truck> queryTruckByTruckNum(
            @RequestParam(value = "truck_num") String truck_num,
            @RequestParam(value = "pageNum",defaultValue = Contants.pageNum) int pageNum,
            @RequestParam(value = "pageSize",defaultValue =Contants.pageSize)int pageSize){
        return service.queryTruckByTruckNum(truck_num,pageNum,pageSize);
    }

    @PostMapping("/addTruck")
    public String addTruck(@RequestBody Truck truck){
        service.addTruck(truck);
        return "redirect:/truckManage/allTruck";
    }

    @PostMapping("/update")
    public String updateTruck(@RequestBody Truck truck){
        service.updateTruck(truck);
        return "redirect:/truckManage/allTruck";
    }

    @PostMapping("/delete/{truck_num}")
    public String deleteTruckByTruckNum(@PathVariable("truck_num") String truck_num){
        service.deleteTruckByTruckNum(truck_num);
        return "redirect:/truckManage/allTruck";
    }

    @ResponseBody
    @GetMapping("/queryNum")
    public List<String> queryTruckNum(@RequestParam(value = "pageNum",defaultValue = Contants.pageNum) int pageNum,
                                      @RequestParam(value = "pageSize",defaultValue =Contants.pageSize)int pageSize){
        return service.queryTruckNum(pageNum,pageSize);
    }

}
