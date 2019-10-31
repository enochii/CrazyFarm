package BusinessDelegate.Business;

import Builder.FarmerMultipleton;
import Farm.Farm;
import Farm.Farmer;
import Farm.Menu;
import java.util.Iterator;

/**
 * @className: CountFarmerService
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 12:29 下午 2019/10/31
 */
public class CountFarmerService implements BusinessService {

    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking Count Farmer Service");

        Farm farm = Farm.getInstance();
        Menu<FarmerMultipleton> m_farmer =  farm.getFarmerMenu();

        int cnt_farmer = m_farmer.getSize();

        System.out.println("Now the number of farmers on the farm is： " + cnt_farmer);

        // 考虑输出每个元素的详细信息
//        Iterator<Farmer> i_farmer = m_farmer.iterator();
    }
}
