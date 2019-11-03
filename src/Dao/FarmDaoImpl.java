package Dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import Farm.Farm;
import com.alibaba.fastjson.JSON;

/**
 * FarmDaoImpl implements FarmDao{@link FarmDao}
 * It uses json format to store Farm Data
 * @className: FarmDaoImpl
 * @author: OY
 * @description: FarmDaoImpl implements FarmDao{@link FarmDao}
 * @designPattern: Dao(数据访问对象模式)
 * @date: 20 :05 2019/10/28
 */
public class FarmDaoImpl implements  FarmDao {

    private String filePath = new String("./Farm.json");

    public Farm getFarm() {
        try {
            FileInputStream in = new FileInputStream(filePath);
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            String jsonString = new String(buffer, "UTF-8");
            Farm farm = (Farm) JSON.parseObject(jsonString, Farm.class);
            System.out.println("Farm data is Loaded");
            return farm;
        } catch(Exception i) {
            //i.printStackTrace();
            System.out.println("缺少文件 Farm.json");
            return null;
        }
    }

    public void updateFarm(Farm farm) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            String jsonString = JSON.toJSONString(farm);
            fileOut.write(jsonString.getBytes());
            fileOut.close();
            System.out.println("Farm data is saved");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void deleteFarm() {
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(filePath);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Farm data is deleted");
    }
}
