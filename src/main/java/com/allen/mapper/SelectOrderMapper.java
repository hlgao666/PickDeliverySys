package com.allen.mapper;

import com.allen.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Allen
 * @date 2021/3/14 11:29
 */

@Mapper
@Repository
public interface SelectOrderMapper {
    //根据油库和日期添加全部订单从表 candidate_order 到表 logistics_oil_order
    void addAllOrderByDepotAndDate(String oil_depot_no, String order_date);

    //手动添加单个订单,到两张表
    void addSingleOrder(Order order);
    void addSingleOrderToCandidate(Order order);

    //移除订单，仅移除logistics_oil_order表的订单
    void removeSingleOrder(String order_id);

    //修改订单, 修改两张表的订单
    void updateOrder(Order order);
    void updateCandidateOrder(Order order);

    //查询所有已选中的订单，从logistics_oil_order表查询
    List<Order> allSelectedOrder();

    //根据参数(D:oil_depot_no, D:order_date, P:priority, O:off_for1、off_for2)组合查询订单。从 candidate_order表查询
    List<Order> queryOrderByDDPO(Map<String,Object> map);

    //清空 logistics_oil_order表
    void truncateTable();
}
