package com.allen.controller;

import com.allen.pojo.Depot;
import com.allen.pojo.UsableOil;
import com.allen.service.DepotManageService;
import com.allen.util.Contants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Allen
 * @date 2021/5/22 16:46
 */

@Controller
@RequestMapping(path = "/oilDepotManage", method={RequestMethod.POST,RequestMethod.GET})
public class DepotManageController {

    @Autowired
    DepotManageService service;

    @ResponseBody
    @GetMapping("/allDepotPosition")
    public List<Depot> allDepotPosition(@RequestParam(value = "pageNum",defaultValue = Contants.pageNum) int pageNum,
                                        @RequestParam(value = "pageSize",defaultValue = Contants.pageSize)int pageSize){
        return service.allDepotPosition(pageNum,pageSize);
    }

    @PostMapping("/addDepotPosition")
    public String addDepotPosition(@RequestBody Depot depot){
        service.addDepotPosition(depot);
        return "redirect:/oilDepotManage/allDepotPosition";
    }

    @PostMapping("/removeOnePosition/{oil_depot_no}")
    public String deleteDepotPosition(@PathVariable("oil_depot_no") String oil_depot_no){
        service.deleteDepotPosition(oil_depot_no);
        return "redirect:/oilDepotManage/allDepotPosition";
    }

    @PostMapping("/updateDepotPosition")
    public String updateDepotPosition(@RequestBody Depot depot){
        service.updateDepotPosition(depot);
        return "redirect:/oilDepotManage/allDepotPosition";
    }

    @ResponseBody
    @GetMapping("/queryPositionById/{oil_depot_no}")
    public Depot selectDepotByDepotNo(@PathVariable("oil_depot_no") String oil_depot_no){
        return service.selectDepotByDepotNo(oil_depot_no);
    }

    //////////////////////////////////////////////////


    @ResponseBody
    @GetMapping("/allUsableOil")
    public List<UsableOil> allUsableOil(@RequestParam(value = "pageNum",defaultValue = Contants.pageNum) int pageNum,
                                        @RequestParam(value = "pageSize",defaultValue = Contants.pageSize)int pageSize){
        return service.allUsableOil(pageNum,pageSize);
    }


    @PostMapping("/addDepotUsableOil")
    public String addDepotUsableOil(@RequestBody UsableOil usableOil){
        service.addDepotUsableOil(usableOil);
        return "redirect:/oilDepotManage/allUsableOil";
    }

    @PostMapping("/deleteDepotUsableOil/{oil_depot_no}/{oil_pot_no}")
    public String deleteDepotUsableOil(@PathVariable("oil_depot_no") String oil_depot_no, @PathVariable("oil_pot_no") String oil_pot_no){
        service.deleteDepotUsableOil(oil_depot_no,oil_pot_no);
        return "redirect:/oilDepotManage/allUsableOil";
    }

    @PostMapping("/updateDepotUsableOil")
    public String updateDepotUsableOil(@RequestBody UsableOil usableOil){
        service.updateDepotUsableOil(usableOil);
        return "redirect:/oilDepotManage/allUsableOil";
    }

    @ResponseBody
    @GetMapping("/queryUsableOilByDepot")
    public List<UsableOil> selectUsableOilByDepot(@RequestParam(value = "oil_depot_no") String oil_depot_no,
                                                  @RequestParam(value = "pageNum",defaultValue = Contants.pageNum)int pageNum,
                                                  @RequestParam(value = "pageSize",defaultValue = Contants.pageSize) int pageSize){
        return service.selectUsableOilByDepot(oil_depot_no,pageNum,pageSize);
    }

}
