import Adapter.ChickenAdapter;
import Constant.Const;
import Dao.FarmDao;
import Dao.FarmDaoImpl;
import Farm.Farm;
import Farm.Menu;
import Interpreter.Parser;
import Farm.Owner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import Livings.Animals.Chicken.TableChicken;
import Observer.Observable.TimeCounter;
import junit.framework.JUnit4TestAdapter;
import mediator.AnimalMediator;

import java.util.Observable;
import java.util.Observer;
import Observer.AnimalsObserver;
import Observer.PlantsObserver;
import mediator.PlantMediator;

public class Main {

    public static void main(String[] args) {
	// write your code here

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

//        System.out.println(farm.getOwner().getMoney());

        owner.purchase(Const.NAME_TABLE_CHICKEN, 3);
        System.out.println(owner.getMoney());

        TimeCounter timeCounter = new TimeCounter();
        AnimalsObserver animalsObserver = new AnimalsObserver();
        PlantsObserver plantsObserver = new PlantsObserver();

        timeCounter.addObserver(animalsObserver);
        timeCounter.addObserver(plantsObserver);

        for(int i = 1; i <= 100; i++)
        {
            timeCounter.updateTime();
        }

        //系统结束时保存Farm
        FarmDao farmDao=new FarmDaoImpl();
        farmDao.updateFarm(farm);
    }
}
