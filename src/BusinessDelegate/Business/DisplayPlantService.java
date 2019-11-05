package BusinessDelegate.Business;

import Farm.Farm;
import Farm.Menu;
import Livings.Animals.Animal;
import Livings.Plants.Plant;
import Visitor.ExpLivingVisitor;

import java.util.Iterator;

/**
 * The Display plant service.
 * 展示农场内所有农作物的业务服务，实现了业务服务接口。
 *
 * @className: DisplayPlantService
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 12 :40 下午 2019/10/31
 */
public class DisplayPlantService implements BusinessService {

    @Override
    public void doProcessing() {

        Farm farm = Farm.getInstance();

        System.out.println("======== 使用业务代表 Business Delegate 模式 ========");
        System.out.println("通过农场主终端执行\"查看农作物\"业务服务");

        Menu<Plant> m_plant =  farm.getPlantMenu();

        int cnt_plant = m_plant.getSize();

        System.out.println("Now the number of plants on the farm is： " + cnt_plant);

        // 利用Visitor模式输出每个作物的类型和经验值
        ExpLivingVisitor expLivingVisitor=new ExpLivingVisitor();
        for(Iterator<Plant>it=m_plant.iterator();it.hasNext(); ){
            Plant plant=it.next();
            plant.accept(expLivingVisitor);
        }

    }
}
