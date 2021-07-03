package com.allen.service;

import com.allen.pojo.Order;

import java.util.List;
import java.util.Map;

/**
 * @author Allen
 * @date 2021/3/15 21:36
 */
public interface SelectOrderService {
    //根据区域和日期添加全部订单到表 candidate_order
    void addAllOrderByDepotAndDate(String oil_depot_no,String order_date);

    //手动添加单个订单,到两张表
    void addSingleOrder(Order order);

    //移除订单，仅移除logistics_oil_order表的订单
    void removeSingleOrder(String order_id);

    //修改订单, 修改两张表的订单
    void updateOrder(Order order);

    //查询所有订单，从logistics_oil_order表查询
    List<Order> allSelectedOrder(int pageNum, int pageSize);

    //根据参数(D:oil_depot_no, D:order_date, P:priority, O:off_for1、off_for2)组合查询订单。从 candidate_order表查询
    List<Order> queryOrderByDDPO(Map<String,Object> map);
}
