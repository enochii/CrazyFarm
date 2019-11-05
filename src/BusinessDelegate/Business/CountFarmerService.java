package BusinessDelegate.Business;

import Builder.FarmerMultipleton;
import Farm.Farm;
import Farm.Farmer;
import Farm.Menu;
import java.util.Iterator;

/**
 * The type Count farmer service.
 * 统计农民数量的业务服务，实现了业务服务接口。
 *
 * @className: CountFarmerService
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 12 :29 下午 2019/10/31
 */
public class CountFarmerService implements BusinessService {

    @Override
    public void doProcessing() {

        Farm farm = Farm.getInstance();

        System.out.println("======== 使用业务代表 Business Delegate 模式 ========");
        System.out.println("通过农场主终端执行\"管理农民\"业务服务");

        Menu<FarmerMultipleton> m_farmer =  farm.getFarmerMenu();

        int cnt_farmer = m_farmer.getSize();

        System.out.println("Now the number of farmers on the farm is： " + cnt_farmer);
        System.out.println("The names of the farmers are: ");

        for(Iterator<FarmerMultipleton>it=m_farmer.iterator();it.hasNext(); ){
            FarmerMultipleton farmer=it.next();
            System.out.println(farmer.getName());
        }
    }
}
