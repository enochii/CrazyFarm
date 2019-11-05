package Dao;

import java.io.*;
import java.util.Base64;


import Farm.Farm;
import com.alibaba.fastjson.JSON;

/**
 * FarmDaoImpl implements FarmDao{@link FarmDao}
 * It uses json format to store Farm Data
 *
 * @className: FarmDaoImpl
 * @author: OY
 * @description: FarmDaoImpl implements FarmDao{@link FarmDao}
 * @designPattern: Dao(数据访问对象模式)
 * @date: 20 :05 2019/10/28
 */
public class FarmDaoImpl implements  FarmDao {

    private String filePath = new String("./Farm.dat");

    /**
     * read date from local file Farm.dat and then return the farm
     * @return Farm
     */
    @Override
    public Farm getFarm(){
        try {
            FileInputStream in = new FileInputStream(filePath);
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            String str = new String(buffer, "UTF-8");
            Farm state_farm = (Farm) fromString(str);
            return state_farm;
        } catch (ClassNotFoundException | IOException e) {
            return null;
        }
    }

    /**
     * store the farm to local file
     * @param farm the Farm to be stored
     */
    @Override
    public void updateFarm(Farm farm) {

        try {
            String str=toString(farm);
            FileOutputStream fileOut = new FileOutputStream(filePath);
            fileOut.write(str.getBytes());
            fileOut.close();
            System.out.println("Farm data is saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /** Read the object from Base64 string. */
    private  Object fromString( String s ) throws IOException,
            ClassNotFoundException {
        byte [] data = Base64.getDecoder().decode( s );
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(  data ) );
        Object o  = ois.readObject();
        ois.close();
        return o;
    }

    /** Write the object to a Base64 string. */
    private String toString( Serializable o ) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject( o );
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }
}
