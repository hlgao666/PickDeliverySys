package com.allen.service.Impl;

import com.allen.mapper.SchemeMapper;
import com.allen.pojo.StationAssignDetail;
import com.allen.pojo.TruckTripDetail;
import com.allen.service.SchemeService;
import com.allen.util.Contants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mathworks.toolbox.javabuilder.MWCharArray;
import com.mathworks.toolbox.javabuilder.MWException;
import externalAlgorithm.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Allen
 * @date 2021/3/13 19:35
 */

@Service
public class SchemeServiceImpl implements SchemeService {

    @Autowired
    SchemeMapper mapper;

    @Autowired
    RedisTemplate redisTemplate;

    public static final String CACHE_KEY_TRUCKTRIP = "truckTrip:";

    @Override
    public void callAlgorithm(MWCharArray oil_depot_no, MWCharArray order_date) throws MWException {
        Call call = new Call();
        call.mainVNSA(oil_depot_no, order_date);

        //更新缓存
        // 更新方案缓存。只更新默认页码、默认页大小的缓存
        String truckTripKey = CACHE_KEY_TRUCKTRIP+Contants.pageNum+Contants.pageSize;
        List<TruckTripDetail> lists = mapper.allTruckTrip();
        redisTemplate.opsForValue().set(truckTripKey,lists);

        mapper.resultCopy();
    }

    @Override
    public List<TruckTripDetail> allTruckTrip(int pageNum, int pageSize) {

        ValueOperations<String,List<TruckTripDetail>> operations = redisTemplate.opsForValue();
        //缓存 key
        String key = CACHE_KEY_TRUCKTRIP+pageNum+pageSize;
        //先查Redis
        List<TruckTripDetail> lists = operations.get(key);
        //缓存未命中
        if(null==lists){
            PageHelper.startPage(pageNum, pageSize);
            lists = mapper.allTruckTrip();
            operations.set(key,lists);
        }
        PageInfo<TruckTripDetail> pi = new PageInfo<>(lists);
        return pi.getList();
    }

    @Override
    public List<TruckTripDetail> truckTripDetail(String truck_num,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TruckTripDetail> lists = mapper.truckTripDetail(truck_num);
        PageInfo<TruckTripDetail> pi = new PageInfo<>(lists);
        return pi.getList();
    }

    @Override
    public List<StationAssignDetail> allStationOrder(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<StationAssignDetail> lists = mapper.allStationOrder();
        PageInfo<StationAssignDetail> pi = new PageInfo<>(lists);
        return pi.getList();
    }

    @Override
    public List<StationAssignDetail> stationOrderDetail(String oil_station_id,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<StationAssignDetail> lists = mapper.stationOrderDetail(oil_station_id);
        PageInfo<StationAssignDetail> pi = new PageInfo<>(lists);
        return pi.getList();
    }

    @Override
    public String queryResultTime() {
        return mapper.queryResultTime();
    }

    @Override
    public Double queryResultRevenue() {
        return mapper.queryResultRevenue();
    }
}
