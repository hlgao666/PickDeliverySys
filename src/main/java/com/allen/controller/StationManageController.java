package com.allen.controller;

import com.allen.pojo.OilCan;
import com.allen.pojo.Station;
import com.allen.pojo.StationDistance;
import com.allen.service.StationManageService;
import com.allen.util.Contants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Allen
 * @date 2021/6/7 23:00
 */

@Controller
@RequestMapping(path = "/stationManage", method={RequestMethod.POST,RequestMethod.GET})
public class StationManageController {

    @Autowired
    StationManageService service;

    @PostMapping("/addStationPosition")
    public String addStationPosition(@RequestBody Station station){
        service.addStationPosition(station);
        return "redirect:/stationManage/allStationPosition";
    }

    @PostMapping("/deleteStationPosition/{oil_station_id}")
    public String deleteStationPosition(@PathVariable("oil_station_id") String oil_station_id){
        service.deleteStationPosition(oil_station_id);
        return "redirect:/stationManage/allStationPosition";
    }

    @PostMapping("/updateStationPosition")
    public String updateStationPosition(@RequestBody Station station){
        service.updateStationPosition(station);
        return "redirect:/stationManage/allStationPosition";
    }

    @ResponseBody
    @GetMapping("/queryById/{oil_station_id}")
    public Station queryStationById(@PathVariable("oil_station_id") String oil_station_id){
        return service.queryStationById(oil_station_id);
    }

    @ResponseBody
    @GetMapping("/allStationPosition")
    public List<Station> allStationPosition(@RequestParam(value = "pageNum",defaultValue = Contants.pageNum) int pageNum,
                                            @RequestParam(value = "pageSize",defaultValue =Contants.pageSize)int pageSize){
        return service.allStationPosition(pageNum,pageSize);
    }

    //////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/addDistance")
    public String addDistance(@RequestBody StationDistance stationDistance){
        service.addDistance(stationDistance);
        return "redirect:/stationManage/allDistance";
    }

    @PostMapping("/deleteDistance")
    public String deleteDistance(@RequestBody StationDistance stationDistance){
        service.deleteDistance(stationDistance);
        return "redirect:/stationManage/allDistance";
    }

    @PostMapping("/updateDistance")
    public String updateDistance(@RequestBody StationDistance stationDistance){
        service.updateDistance(stationDistance);
        return "redirect:/stationManage/allDistance";
    }

    @ResponseBody
    @GetMapping("/queryByIds/{oil_station_id1}/{oil_station_id2}")
    public StationDistance queryByIds(@PathVariable("oil_station_id1") String oil_station_id1, @PathVariable("oil_station_id2") String oil_station_id2){
        return service.queryByIds(oil_station_id1,oil_station_id2);
    }

    @ResponseBody
    @GetMapping("/allDistance")
    public List<StationDistance> allDistance(@RequestParam(value = "pageNum",defaultValue = Contants.pageNum) int pageNum,
                                             @RequestParam(value = "pageSize",defaultValue =Contants.pageSize)int pageSize){
        return service.allDistance(pageNum,pageSize);
    }

    //////////////////////////////////////////////////////////////////////

    @PostMapping("/addOilCan")
    public String addOilCan(@RequestBody OilCan oilCan){
        service.addOilCan(oilCan);
        return "redirect:/stationManage/allOilCan";
    }

    @PostMapping("/deleteOilCan/{oil_station_id}/{pot_no}")
    public String deleteOilCan(@PathVariable("oil_station_id") String oil_station_id, @PathVariable("pot_no") String pot_no){
        service.deleteOilCan(oil_station_id,pot_no);
        return "redirect:/stationManage/allOilCan";
    }

    @PostMapping("/updateOilCan")
    public String updateOilCan(@RequestBody OilCan oilCan){
        service.updateOilCan(oilCan);
        return "redirect:/stationManage/allOilCan";
    }

    @ResponseBody
    @GetMapping("/queryByDepot")
    public List<OilCan> queryByDepot(
            @RequestParam(value = "oil_depot_no") String oil_depot_no,
            @RequestParam(value = "pageNum",defaultValue = Contants.pageNum) int pageNum,
            @RequestParam(value = "pageSize",defaultValue =Contants.pageSize)int pageSize){
        return service.queryByDepot(oil_depot_no,pageNum,pageSize);
    }

    @ResponseBody
    @GetMapping("/allOilCan")
    public List<OilCan> allOilCan(@RequestParam(value = "pageNum",defaultValue = Contants.pageNum) int pageNum,
                                  @RequestParam(value = "pageSize",defaultValue =Contants.pageSize)int pageSize){
        return service.allOilCan(pageNum,pageSize);
    }
}
