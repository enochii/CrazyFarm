import Constant.Const;
import Farm.Farm;
import Farm.Owner;
import Observer.AnimalsObserver;
import Observer.Observable.TimeCounter;
import Observer.PlantsObserver;
import mediator.AnimalMediator;
import mediator.PlantMediator;
import org.junit.Before;
import org.junit.Test;

public class ChainOtherTest {
    @Before
    public void setUp(){
        System.out.println("============= 测试责任链模式 ==============");
    }

    @Test
    public void test(){
        //获取农场实例并对其进行初始化
        Farm farm = Farm.getInstance();

        AnimalMediator animalMediator = new AnimalMediator();
        PlantMediator plantMediator = new PlantMediator();

        farm.setMediatorForFarm(animalMediator, plantMediator);
        farm.addMediatorForAll();
        animalMediator.setFarm(farm);
        plantMediator.setFarm(farm);

        Owner owner = Owner.getInstance();
        farm.setOwnerForFarm(owner);
        owner.setFarmForOwner(farm);
        owner.purchase(Const.NAME_TABLE_CHICKEN, 7);
        farm.addMediatorForAll();
        System.out.println(owner.getMoney());

        TimeCounter timeCounter = new TimeCounter();
        AnimalsObserver animalsObserver = new AnimalsObserver();
        PlantsObserver plantsObserver = new PlantsObserver();
        timeCounter.addObserver(animalsObserver);
        timeCounter.addObserver(plantsObserver);
        //模拟时间流逝，观察农场中的信息更新
        for(int i = 1; i <= 110; i++)
        {
            timeCounter.updateTime();
        }
    }
}
