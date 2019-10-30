package Dao;

import Farm.Farm;

/**
 * FarmDao is a interface which defines Farm Data access method
 * It can store/delete or get Farm Data from local system
 * @className: FarmDao
 * @author: OY
 * @description: FarmDao is a interface which defines Farm Data access method
 * @designPattern: Dao(数据访问对象模式)
 * @date: 20 :05 2019/10/28
 */
public interface FarmDao {
    public Farm getFarm();
    public void updateFarm(Farm Farm);
    public void deleteFarm();
 }
