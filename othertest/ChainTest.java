import Constant.Const;
import Farm.Farm;
import Farm.Owner;
import Observer.AnimalsObserver;
import Observer.Observable.TimeCounter;
import Observer.PlantsObserver;
import mediator.AnimalMediator;
import mediator.PlantMediator;
import org.junit.Test;

public class ChainTest {
    @Before
    public void setUp(){
        system.out.println("============= 测试责任链模式 ==============");

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
    }

    @Test
    public void test(){
        for(int i = 1; i <= 110; i++)
        {
            timeCounter.updateTime();
        }
    }
}
