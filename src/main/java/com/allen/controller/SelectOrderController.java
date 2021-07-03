package com.allen.controller;

import com.allen.pojo.Order;
import com.allen.service.SelectOrderService;
import com.allen.util.Contants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Allen
 * @date 2021/3/15 21:44
 */

@Controller
@RequestMapping(path = "/selectOrder",method = {RequestMethod.GET,RequestMethod.POST})
public class SelectOrderController {

    @Autowired
    SelectOrderService selectOrderService;

    @ResponseBody
    @GetMapping("/allOrder")
    public List<Order> allOrder(@RequestParam(value = "pageNum",defaultValue = Contants.pageNum) int pageNum,
                                @RequestParam(value = "pageSize",defaultValue = Contants.pageSize)int pageSize){
        return selectOrderService.allSelectedOrder(pageNum,pageSize);
    }

    @ResponseBody
    @GetMapping("/byDisDate/{oil_depot_no}/{order_date}")
    public String addAllOrderByDepotAndDate(@PathVariable("oil_depot_no") String oil_depot_no, @PathVariable("order_date") String order_date){
        selectOrderService.addAllOrderByDepotAndDate(oil_depot_no,order_date);
        return "redirect:/selectOrder/allOrder";
    }


    @PostMapping("/addOne")
    public String addSingleOrder(@RequestBody Order order){
        selectOrderService.addSingleOrder(order);
        return "redirect:/selectOrder/allOrder";
    }


    @PostMapping("/removeOne/{order_id}")
    public String removeSingleOrder(@PathVariable("order_id") String order_id){
        selectOrderService.removeSingleOrder(order_id);
        return "redirect:/selectOrder/allOrder";
    }


    @PostMapping("/update")
    public String updateOrder(@RequestBody Order order){
        selectOrderService.updateOrder(order);
        return "redirect:/selectOrder/allOrder";
    }

    //这里前端使用form-data格式(key1=v1&key2=v2)提交数据，注意字段名要一致
    @ResponseBody
    @GetMapping("/queryByDDPO")
    public List<Order> queryOrderByDDPO(@RequestParam Map<String, Object> map){
        return selectOrderService.queryOrderByDDPO(map);
    }
}
