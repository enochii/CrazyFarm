package Dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import net.sf.json.*;

import Farm.Farm;

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
            String str = new String(buffer, "UTF-8");
            JSONObject obj = new JSONObject().fromObject(str);
            Farm farm = (Farm)JSONObject.toBean(obj, Farm.class);
            System.out.printf("Farm data is Loaded");
            return farm;
        } catch(Exception i) {
            i.printStackTrace();
            return null;
        }
    }

    public void updateFarm(Farm Farm) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            JSONObject json = JSONObject.fromObject(Farm);
            String str = json.toString();
            fileOut.write(str.getBytes());
            fileOut.close();
            System.out.printf("Farm data is saved");
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
        System.out.printf("Farm data is deleted");
    }
}
