package BusinessDelegate.Business;

import Farm.Farm;
import Farm.Menu;
import Livings.Plants.Plant;
import java.util.Iterator;

/**
 * @className: DisplayPlantService
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 12:40 下午 2019/10/31
 */
public class DisplayPlantService implements BusinessService {

    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking Display Plant Service");

        Farm farm = Farm.getInstance();
        Menu<Plant> m_plant =  farm.getPlantMenu();

        int cnt_plant = m_plant.getSize();

        System.out.println("Now the number of plants on the farm is： " + cnt_plant);

        // 考虑输出每个元素的详细信息
//        Iterator<Plant> i_plant = m_plant.iterator();


    }
}
