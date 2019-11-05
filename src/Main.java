import AbstractFactory.AbstractToolFactory;
import AbstractFactory.IronToolFactory;
import AbstractFactory.StainlessSteelToolFactory;
import Adapter.ChickenAdapter;
import Adapter.MakeDuckQuack;
import Builder.FarmerMultipleton;
import BusinessDelegate.BusinessDelegate;
import Constant.Const;
import Converter.CropConverter;
import Dao.FarmDao;
import Dao.FarmDaoImpl;
import Factory.Factory;
import Farm.Farm;
import Farm.Menu;
import Farm.Owner;
import Interpreter.ParseException;
import Interpreter.Parser;
import Land.*;
import Factory.*;
import Livings.Animals.Chicken.TableChicken;
import MVC.FarmerController;
import MVC.FarmerView;
import Memento.CropStateMemento;
import Observer.AnimalsObserver;
import Observer.Observable.TimeCounter;
import Observer.PlantsObserver;
import Tools.Extension.AugmentedHoe;
import Tools.FarmTool;
import mediator.AnimalMediator;
import mediator.PlantMediator;
import BusinessDelegate.Client;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // 初始化农场，根据调用关系先后用到了以下设计模式：
        // 单例模式
        // 双重检查锁模式
        // 建造者模式
        // 抽象工厂模式 和 享元模式
        // 桥接模式
        Farm farm = Farm.getInstance();

        // 工厂模式
        Factory fieldFactory = new FieldFactory();
        Field field1 = (Field) fieldFactory.create("种植玉米");
        System.out.println("创建了一小块土地用于" + field1.getUsage() + ".");
        Field field2 = (Field) fieldFactory.create("种植土豆");
        System.out.println("创建了一小块土地用于" + field2.getUsage() + ".");

        Factory largeFieldFactory = new LargeFieldFactory();
        LargeField largeField1 = (LargeField) largeFieldFactory.create("放养鸭子");
        System.out.println("创建了一大片土地用于" + largeField1.getUsage() + ".");
        LargeField largeField2 = (LargeField) largeFieldFactory.create("放养鸡");
        System.out.println("创建了一大片土地用于" + largeField2.getUsage() + ".");

        // 中介者模式
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

        // 业务代表模式
        // 内部还会用到迭代器模式
        BusinessDelegate businessDelegate = new BusinessDelegate();
        Client client = new Client(businessDelegate);
        businessDelegate.setBusinessService(Const.SERVICE_CNT_FARMER);
        client.doTask();
        businessDelegate.setBusinessService(Const.SERVICE_DISPLAY_PLANT);
        client.doTask();

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

        //系统结束时保存Farm
        FarmDao farmDao=new FarmDaoImpl();
        farmDao.updateFarm(farm);
    }
}
