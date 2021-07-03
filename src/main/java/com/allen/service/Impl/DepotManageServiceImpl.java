package com.allen.service.Impl;

import com.allen.mapper.DepotManageMapper;
import com.allen.pojo.Depot;
import com.allen.pojo.UsableOil;
import com.allen.service.DepotManageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Allen
 * @date 2021/5/22 16:32
 */

@Service
public class DepotManageServiceImpl implements DepotManageService {

    @Autowired
    DepotManageMapper manageMapper;


    @Override
    public void addDepotPosition(Depot depot) {
        manageMapper.addDepotPosition(depot);
    }

    @Override
    public void deleteDepotPosition(String oil_depot_no) {
        manageMapper.deleteDepotPosition(oil_depot_no);
    }

    @Override
    public void updateDepotPosition(Depot depot) {
        manageMapper.updateDepotPosition(depot);
    }

    @Override
    public Depot selectDepotByDepotNo(String oil_depot_no) {
        return manageMapper.selectDepotByDepotNo(oil_depot_no);
    }

    @Override
    public List<Depot> allDepotPosition(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Depot> lists = manageMapper.allDepotPosition();
        PageInfo<Depot> pi = new PageInfo<>(lists);
        return pi.getList();
    }

    //////////////////////////////////////////////////////////////////////////////////

    @Override
    public void addDepotUsableOil(UsableOil usableOil) {
        manageMapper.addDepotUsableOil(usableOil);
    }

    @Override
    public void deleteDepotUsableOil(String oil_depot_no, String oil_pot_no) {
        manageMapper.deleteDepotUsableOil(oil_depot_no,oil_pot_no);
    }

    @Override
    public void updateDepotUsableOil(UsableOil usableOil) {
        manageMapper.updateDepotUsableOil(usableOil);
    }

    @Override
    public List<UsableOil> selectUsableOilByDepot(String oil_depot_no, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UsableOil> lists = manageMapper.selectUsableOilByDepot(oil_depot_no);
        PageInfo<UsableOil> pi = new PageInfo<>(lists);
        return pi.getList();
    }

    @Override
    public List<UsableOil> allUsableOil(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UsableOil> lists = manageMapper.allUsableOil();
        PageInfo<UsableOil> pi = new PageInfo<>(lists);
        return pi.getList();
    }
}
