package Dao;

import Farm.Farm;

/**
 * FarmDao is a interface which defines Farm Data access method
 * It can store/delete or get Farm Data from local system
 *
 * @className: FarmDao
 * @author: OY
 * @description: FarmDao is a interface which defines Farm Data access method
 * @designPattern: Dao(数据访问对象模式)
 * @date: 20 :05 2019/10/28
 */
public interface FarmDao {

    /**
     * Gets farm Date.
     * @return the farm
     */
    public Farm getFarm();

    /**
     * Update farm Date .
     * @param Farm the farm
     */
    public void updateFarm(Farm Farm);

 }
