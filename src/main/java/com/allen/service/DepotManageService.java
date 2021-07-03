package com.allen.service;

import com.allen.pojo.Depot;
import com.allen.pojo.UsableOil;

import java.util.List;

/**
 * @author Allen
 * @date 2021/5/22 16:31
 */
public interface DepotManageService {

    /*
     *
     * @author allen
     * @date 2021/5/22 16:14
     * @param 油库实体
     */
    void addDepotPosition(Depot depot);

    /*
     *
     * @author allen
     * @date 2021/5/22 16:14
     * @param 油库编号
     */
    void deleteDepotPosition(String oil_depot_no);

    /*
     *
     * @author allen
     * @date 2021/5/22 16:16
     * @param 油库实体
     */
    void updateDepotPosition(Depot depot);

    /*
     *
     * @author allen
     * @date 2021/5/22 16:18
     * @param 油库编号
     * @return com.allen.pojo.OilDepot
     */
    Depot selectDepotByDepotNo(String oil_depot_no);

    /*
     *
     * @author allen
     * @date 2021/5/22 16:54
     * @return java.util.List<com.allen.pojo.OilDepot>
     */
    List<Depot> allDepotPosition(int pageNum, int pageSize);



    /*
     *
     * @author allen
     * @date 2021/5/22 20:08
     * @param depotUsableOil DepotUsableOil实体类
     */
    //注意：仅能添加部分属性
    void addDepotUsableOil(UsableOil usableOil);

    /*
     *
     * @author allen
     * @date 2021/5/22 20:10
     * @param oil_depot_no 油库编号
     * @param oil_pot_no 油罐编号
     */
    void deleteDepotUsableOil(String oil_depot_no, String oil_pot_no);

    /*
     *
     * @author allen
     * @date 2021/5/22 20:12
     * @param depotUsableOil DepotUsableOil实体类
     */
    void updateDepotUsableOil(UsableOil usableOil);

    /*
     *
     * @author allen
     * @date 2021/5/22 20:14
     * @param oil_depot_no 油库编号
     * @return java.util.List<com.allen.pojo.DepotUsableOil>
     */
    List<UsableOil> selectUsableOilByDepot(String oil_depot_no, int pageNum, int pageSize);

    /*
     *
     * @author allen
     * @date 2021/5/22 20:14
     * @return java.util.List<com.allen.pojo.DepotUsableOil>
     */
    List<UsableOil> allUsableOil(int pageNum, int pageSize);
}
