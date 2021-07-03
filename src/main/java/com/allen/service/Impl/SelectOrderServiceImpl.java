package com.allen.service.Impl;

import com.allen.mapper.SelectOrderMapper;
import com.allen.pojo.Order;
import com.allen.service.SelectOrderService;
import com.allen.util.Contants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Allen
 * @date 2021/3/15 21:36
 */

@Service
public class SelectOrderServiceImpl implements SelectOrderService {

    @Autowired
    SelectOrderMapper selectOrderMapper;

    @Override
    public void addAllOrderByDepotAndDate(String oil_depot_no, String order_date) {
        selectOrderMapper.truncateTable();
        selectOrderMapper.addAllOrderByDepotAndDate(oil_depot_no, order_date);
    }

    @Override
    public void addSingleOrder(Order order) {
        selectOrderMapper.addSingleOrder(order);
        selectOrderMapper.addSingleOrderToCandidate(order);
    }


    @Override
    public void removeSingleOrder(String order_id) {
        selectOrderMapper.removeSingleOrder(order_id);
    }

    @Override
    public void updateOrder(Order order) {
        selectOrderMapper.updateOrder(order);
        selectOrderMapper.updateCandidateOrder(order);
    }


    @Override
    public List<Order> allSelectedOrder(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> lists = selectOrderMapper.allSelectedOrder();
        PageInfo<Order> pi = new PageInfo<>(lists);
        return pi.getList();
    }

    @Override
    public List<Order> queryOrderByDDPO(Map<String, Object> map){
        if(!map.containsKey("pageNum")){
            map.put("pageNum", Contants.pageNum);
        }
        if(!map.containsKey("pageSize")){
            map.put("pageSize", Contants.pageSize);
        }
        PageHelper.startPage(Integer.parseInt((String) map.get("pageNum")),Integer.parseInt((String) map.get("pageSize")));
        List<Order> lists = selectOrderMapper.queryOrderByDDPO(map);
        PageInfo<Order> pi = new PageInfo<>(lists);
        return pi.getList();
    }

}
