package com.allen.controller;

import com.allen.pojo.Order;
import com.allen.service.OrderManageService;
import com.allen.util.Contants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Allen
 * @date 2021/5/23 15:16
 */

@Controller
@RequestMapping(path = "/orderManage", method={RequestMethod.POST,RequestMethod.GET})
public class OrderManageController {

    @Autowired
    OrderManageService service;


    @ResponseBody
    @GetMapping("/allOrder")
    public List<Order> selectOrderByPage(@RequestParam(value = "pageNum",defaultValue = Contants.pageNum) int pageNum,
                                         @RequestParam(value = "pageSize",defaultValue =Contants.pageSize)int pageSize){
        return service.allOrder(pageNum, pageSize);
    }

    @PostMapping("/addSingleOrder")
    public String addSingleOrder(@RequestBody Order order){
        service.addSingleOrder(order);
        return "redirect:/orderManage/allOrder";
    }

    @PostMapping("/removeOneOrder/{order_id}")
    public String deleteSingleOrder(@PathVariable("order_id") String order_id){
        service.deleteSingleOrder(order_id);
        return "redirect:/orderManage/allOrder";
    }

    @PostMapping("/updateOrder")
    public String updateOrder(@RequestBody Order order){
        service.updateOrder(order);
        return "redirect:/orderManage/allOrder";
    }

    //换成 map k-v形式 存储参数
    @ResponseBody
    @GetMapping("/selectOrderByDepotAndOffFor")
    public List<Order> selectOrderByDepotAndOffFor(
            @RequestParam Map<String, Object> map){

        return service.selectOrderByDepotAndOffFor(map);
    }
}
