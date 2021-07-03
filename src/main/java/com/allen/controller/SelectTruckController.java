package com.allen.controller;

import com.allen.pojo.Truck;
import com.allen.service.SelectTruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Allen
 * @date 2021/3/16 16:16
 */

@Controller
@RequestMapping(path = "/selectTruck",method = {RequestMethod.GET,RequestMethod.POST})
public class SelectTruckController {

    @Autowired
    SelectTruckService selectTruckService;

    @ResponseBody
    @GetMapping("/show/{oil_depot_no}")
    List<Truck> showCandidateTruckByDepot(@PathVariable("oil_depot_no") String oil_depot_no){
        return selectTruckService.showCandidateTruckByDepot(oil_depot_no);
    }


    @PostMapping("/select")
    public String selectUsableTruck(@RequestParam List<String> truck_num_set){
        selectTruckService.truncateTable();
        selectTruckService.selectUsableTruck(truck_num_set);
        return "redirect:/selectTruck/allSelectedTruck";
    }

    @ResponseBody
    @GetMapping("/allSelectedTruck")
    public List<Truck> allTruck(){
        return selectTruckService.queryAllSelectedTruck();
    }

//    @RequestMapping("/byDepot/{oil_depot_no}")
//    public String selectAllTruckByDepot(@PathVariable String oil_depot_no) {
//        selectTruckService.selectAllTruckByDepot(oil_depot_no);
//        return "redirect:/selectTruck/allTruck";
//    }
//
//    @RequestMapping("/remove/{truck_num}")
//    public String removeSingleTruck(@PathVariable String truck_num) {
//        selectTruckService.removeSingleTruck(truck_num);
//        return "redirect:/selectTruck/allTruck";
//    }
//
//    @RequestMapping("/update")
//    public String updateTruck(Truck truck) {
//        selectTruckService.updateTruck(truck);
//        return "redirect:/selectTruck/allTruck";
//    }
//
//
//    @RequestMapping("/removeAll")
//    public String truncateTable() {
//        selectTruckService.truncateTable();
//        return "redirect:/selectTruck/allTruck";
//    }
}
