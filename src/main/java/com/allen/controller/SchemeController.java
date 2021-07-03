package com.allen.controller;

import com.allen.pojo.StationAssignDetail;
import com.allen.pojo.TruckTripDetail;
import com.allen.service.SchemeService;
import com.allen.util.Contants;
import com.mathworks.toolbox.javabuilder.MWCharArray;
import com.mathworks.toolbox.javabuilder.MWException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Allen
 * @date 2021/3/13 19:38
 */

@Controller
@RequestMapping(path = "/assignResult", method={RequestMethod.POST,RequestMethod.GET})
public class SchemeController {

    @Autowired
    SchemeService schemeService;

    @PostMapping("/call/{oil_depot_no}/{order_date}")
    private String callAlgorithm(@PathVariable("oil_depot_no") String oil_depot_no, @PathVariable("order_date") String order_date, HttpSession session) throws MWException {
        schemeService.callAlgorithm(new MWCharArray(oil_depot_no),new MWCharArray(order_date));

        //保存方案时间和收益到session中，可以session共享！
        String resultTime = schemeService.queryResultTime();
        session.setAttribute("resultTime",resultTime);

        Double resultRevenue = schemeService.queryResultRevenue();
        session.setAttribute("resultRevenue",resultRevenue);

        return "redirect:/assignResult/queryAllByTruck";
    }

    @ResponseBody
    @GetMapping("/queryAllByTruck")
    private List<TruckTripDetail> allTruckTrip(@RequestParam(value = "pageNum",defaultValue = Contants.pageNum) int pageNum,
                                               @RequestParam(value = "pageSize",defaultValue = Contants.pageSize)int pageSize){
        return schemeService.allTruckTrip(pageNum,pageSize);
    }

    @ResponseBody
    @GetMapping("/queryDetailByTruck")
    private List<TruckTripDetail> truckTripDetail(
            @RequestParam(value = "truck_num") String truck_num,
              @RequestParam(value = "pageNum",defaultValue = Contants.pageNum) int pageNum,
              @RequestParam(value = "pageSize",defaultValue = Contants.pageSize)int pageSize){
        return schemeService.truckTripDetail(truck_num,pageNum,pageSize);
    }

    @ResponseBody
    @GetMapping("/queryAllByStation")
    private List<StationAssignDetail> allStationOrder(
            @RequestParam(value = "pageNum",defaultValue = Contants.pageNum) int pageNum,
            @RequestParam(value = "pageSize",defaultValue = Contants.pageSize)int pageSize){
        return schemeService.allStationOrder(pageNum,pageSize);
    }

    @ResponseBody
    @GetMapping("/queryDetailByStation")
    private List<StationAssignDetail> stationOrderDetail(
            @RequestParam(value = "oil_station_id") String oil_station_id,
            @RequestParam(value = "pageNum",defaultValue = Contants.pageNum) int pageNum,
            @RequestParam(value = "pageSize",defaultValue = Contants.pageSize)int pageSize){
        return schemeService.stationOrderDetail(oil_station_id,pageNum,pageSize);
    }

}
