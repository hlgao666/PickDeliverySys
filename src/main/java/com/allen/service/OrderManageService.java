package com.allen.service;

import com.allen.pojo.Order;

import java.util.List;
import java.util.Map;

/**
 * @author Allen
 * @date 2021/5/23 15:13
 */
public interface OrderManageService {

    /*
     *
     * @author allen
     * @date 2021/5/23 14:33
     * @param order
     */
    void addSingleOrder(Order order);

    /*
     *
     * @author allen
     * @date 2021/5/23 14:34
     * @param order_id
     */
    void deleteSingleOrder(String order_id);

    /*
     *
     * @author allen
     * @date 2021/5/23 14:35
     * @param order
     * 仅支持修改部分属性
     */
    void updateOrder(Order order);

    /*
     *
     * @author allen
     * @date 2021/5/23 14:37
     * @param oil_depot_no  油库编号
     * @param off_for 交付期
     * @return com.allen.pojo.Order
     */
    List<Order> selectOrderByDepotAndOffFor(Map<String,Object> map);

    /*
     * 根据页码查询订单集
     * @author allen
     * @date 2021/5/23 14:38
     * @return java.util.List<com.allen.pojo.Order>
     */
    List<Order> allOrder(int pageNum, int pageSize);

}
