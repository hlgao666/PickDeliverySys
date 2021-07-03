package com.allen.service.Impl;

import com.allen.mapper.OrderManageMapper;
import com.allen.pojo.Order;
import com.allen.service.OrderManageService;
import com.allen.util.Contants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Allen
 * @date 2021/5/23 15:14
 */

@Service
public class OrderManageServiceImpl implements OrderManageService {

    @Autowired
    OrderManageMapper mapper;

    @Autowired
    RedisTemplate redisTemplate;

    public static final String CACHE_KEY_ALLORDER = "orderList:";

    @Override
    public void addSingleOrder(Order order) {
        mapper.addSingleOrder(order);
    }

    @Override
    public void deleteSingleOrder(String order_id) {
        mapper.deleteSingleOrder(order_id);
    }

    @Override
    public void updateOrder(Order order) {
        mapper.updateOrder(order);
    }

    @Override
    public List<Order> selectOrderByDepotAndOffFor(Map<String, Object> map) {
        if(!map.containsKey("pageNum")){
            map.put("pageNum", Contants.pageNum);
        }
        if(!map.containsKey("pageSize")){
            map.put("pageSize", Contants.pageSize);
        }
        PageHelper.startPage(Integer.parseInt((String) map.get("pageNum")),Integer.parseInt((String) map.get("pageSize")));
        List<Order> lists = mapper.selectOrderByDepotAndOffFor(map);
        PageInfo<Order> pi = new PageInfo<>(lists);
        return pi.getList();
    }

    @Override
    public List<Order> allOrder(int pageNum, int pageSize) {
        ValueOperations<String,List<Order>> operations = redisTemplate.opsForValue();

        String key = CACHE_KEY_ALLORDER+pageNum+pageSize;
        List<Order> lists = operations.get(key);
        if(null==lists){
            PageHelper.startPage(pageNum, pageSize);
            lists = mapper.allOrder();
            operations.set(key,lists);
        }
        PageInfo<Order> pi = new PageInfo<>(lists);
        return pi.getList();
    }
}
