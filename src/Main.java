import Adapter.ChickenAdapter;
import Adapter.MakeDuckQuack;
import Builder.FarmerMultipleton;
import Constant.Const;
import Converter.CropConverter;
import Dao.FarmDao;
import Dao.FarmDaoImpl;
import Farm.Farm;
import Farm.Menu;
import Farm.Owner;
import Interpreter.ParseException;
import Interpreter.Parser;
import Livings.Animals.Animal;
import Livings.Animals.Chicken.Chicken;
import Livings.Animals.Chicken.TableChicken;
import Livings.Animals.Duck.SmallYellowDuck;
import MVC.FarmerController;
import MVC.FarmerView;
import Memento.CropStateMemento;
import Observer.AnimalsObserver;
import Observer.Observable.TimeCounter;
import Observer.PlantsObserver;
import Tools.Extension.AugmentedHoe;
import criteria.Criteria;
import criteria.CriteriaChicken;
import criteria.CriteriaDuck;
import criteria.CriteriaMature;
import mediator.AnimalMediator;
import mediator.PlantMediator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

        owner.purchase(Const.NAME_TABLE_CHICKEN, 6);
        farm.addMediatorForAll();
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

        //使用 MVC 模式
        System.out.println("======== 使用 MVC 模式 ========");
        Menu<FarmerMultipleton> farmerMenu = farm.getFarmerMenu();
        Iterator<FarmerMultipleton> farmerIter = farmerMenu.iterator();
        int baseAge = 30;
        String baseName = "Farmer";
        int i = 0;

        while(farmerIter.hasNext()){
            FarmerMultipleton farmer = farmerIter.next();
            FarmerView view = new FarmerView();
            FarmerController controller = new FarmerController(farmer, view);
            System.out.println("FarmerController : " + controller.hashCode() +  " :setFarmerAge: set a new age for a farmer");
            controller.setFarmerAge(30 + i);
            System.out.println("FarmerController : " + controller.hashCode() +  " :setFarmerName: set a new age for a farmer");
            controller.setFarmerName(baseName + i);
            System.out.println("FarmerController : " + controller.hashCode() +  " :updateView: update and show the farmer's information");
            controller.updateView();
            i++;
        }

        //适配器
        MakeDuckQuack.makeDuckQuack(new ChickenAdapter(new TableChicken()));
        //解释器
        try {
            Parser.main();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //备忘录
        CropStateMemento.main();
        //转换器
        CropConverter.main();

        // 扩展对象 Extension objects 模式
        AugmentedHoe augmentedHoe = new AugmentedHoe();

        //使用 Filter 模式
        System.out.println("======== 使用 Filter 模式 ========");
        List<Animal> animals = new ArrayList<>();
        Menu<Animal> animalMenu = farm.getAnimalMenu();
        Iterator<Animal> animalIterator = animalMenu.iterator();
        while(animalIterator.hasNext()) {
            Animal animal = animalIterator.next();
            animals.add(animal);
        }
        Criteria criteriaMature = new CriteriaMature();
        System.out.println("CriteriaMature : " + criteriaMature.hashCode() +  " :meetCriteria: filter the mature animals");
        List<Animal> result = criteriaMature.meetCriteria(animals);
        System.out.println(result.get(0).getName());

        //使用 Null Object 模式
        System.out.println("======== 使用 Null Object 模式 ========");
        Criteria criteriaDuck = new CriteriaDuck();
        List<Animal> nullResult = criteriaDuck.meetCriteria(animals);
        nullResult.get(0).getValue();

        //使用 Strategy 模式
        System.out.println("======== 使用 Strategy 模式 ========");
        Animal chicken = result.get(0);
        chicken.makeEat();
        chicken.makeSound();

        //使用 Template method 模式
        System.out.println("======== 使用 Template method 模式 ========");
        Animal duck = new SmallYellowDuck();
        chicken.getFed(101);
        duck.getFed(101);

        //系统结束时保存Farm
        FarmDao farmDao=new FarmDaoImpl();
        farmDao.updateFarm(farm);
    }
}
