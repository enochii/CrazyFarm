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
import Decorator.AnimalDecorator.FreshDecorator;
import Decorator.AnimalDecorator.StaleDecorator;
import Decorator.PlantDecorator.OrganicDecorator;
import Decorator.PlantDecorator.TransgenosisDecorator;
import Factory.Factory;
import Farm.Farm;
import Farm.Menu;
import Farm.Owner;
import Interpreter.ParseException;
import Interpreter.Parser;
import Livings.Animals.Animal;
import Livings.Animals.Chicken.Chicken;
import Livings.Animals.Chicken.TableChicken;
import Livings.Animals.Duck.SmallYellowDuck;
import Land.*;
import Factory.*;
import Livings.Animals.Animal;
import Livings.Animals.Chicken.TableChicken;
import Livings.Plants.Crop;
import Livings.Plants.Plant;
import MVC.FarmerController;
import MVC.FarmerView;
import Memento.CropStateMemento;
import Observer.AnimalsObserver;
import Observer.Observable.TimeCounter;
import Observer.PlantsObserver;
import Proxy.OwnerProxy;
import Specification.specification_test;
import Visitor.ExpLivingVisitor;
import Tools.Extension.AugmentedHoe;
import criteria.Criteria;
import criteria.CriteriaChicken;
import criteria.CriteriaDuck;
import criteria.CriteriaMature;
import Tools.FarmTool;
import mediator.AnimalMediator;
import mediator.PlantMediator;
import BusinessDelegate.Client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // 初始化农场，根据调用关系先后用到了以下设计模式：
        // 双重检查锁模式
        // 建造者模式
        // 抽象工厂模式
        // 享元模式
        // 桥接模式
        // 多例模式
        // 私有类数据模式
        // 组合模式
        Farm farm = Farm.getInstance();

        // 工厂模式
        Factory fieldFactory = new FieldFactory();
        System.out.println("FieldFactory : " + fieldFactory.hashCode() +  " :create: create a field with usage");
        Field field1 = (Field) fieldFactory.create("种植玉米");
        System.out.println("创建了一小块土地用于" + field1.getUsage() + ".");
        Field field2 = (Field) fieldFactory.create("种植土豆");
        System.out.println("创建了一小块土地用于" + field2.getUsage() + ".");

        Factory largeFieldFactory = new LargeFieldFactory();
        System.out.println("LargeFieldFactory : " + largeFieldFactory.hashCode() +  " :create: create a large field with usage");
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

        //单例模式
        Owner owner = Owner.getInstance();
        farm.setOwnerForFarm(owner);
        owner.setFarmForOwner(farm);

//        System.out.println(farm.getOwner().getMoney());

        // 回调模式
        // 命令模式
        owner.purchase(Const.NAME_TABLE_CHICKEN, 3);
        farm.addMediatorForAll();
        System.out.println(owner.getMoney());

        //使用观察者模式
        System.out.println("======== 使用 观察者Observer 模式 ========");
        TimeCounter timeCounter = new TimeCounter();
        System.out.println("建立动物观察者");
        AnimalsObserver animalsObserver = new AnimalsObserver();
        System.out.println("建立植物观察者");
        PlantsObserver plantsObserver = new PlantsObserver();

        timeCounter.addObserver(animalsObserver);
        timeCounter.addObserver(plantsObserver);
        System.out.println("开始更新时间");

        // 多例(multipleton)模式
        farm.getFarmerMenu().add(FarmerMultipleton.getRandomInstance());

        // 状态模式
        // 责任链模式
        // 外观模式
        for(int i = 1; i <= 100; i++)
        {
            System.out.println("Farm's current time is : " + i);
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
        // 迭代器模式
        BusinessDelegate businessDelegate = new BusinessDelegate();
        Client client = new Client(businessDelegate);
        System.out.println("BusinessDelegate : " + businessDelegate.hashCode() +  " :setBusinessService: set a new business service type");
        businessDelegate.setBusinessService(Const.SERVICE_CNT_FARMER);
        System.out.println("Client : " + client.hashCode() +  " :do task of selected business service");
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
        //原型模式
        CropStateMemento.main();
        //转换器
        CropConverter.main();
        //使用 访问者Visitor 模式
        System.out.println("======== 使用 访问者Visitor 模式 ========");
        ExpLivingVisitor expLivingVisitor=new ExpLivingVisitor();
        Menu<Animal> animalmenu=farm.getAnimalMenu();
        Menu<Plant> plantmenu=farm.getPlantMenu();
        System.out.println("访问动物的经验值");
        for(Iterator<Animal>it=animalmenu.iterator();it.hasNext(); ){
            Animal animal=it.next();
            animal.accept(expLivingVisitor);
        }
        System.out.println("访问植物的经验值");
        for(Iterator<Plant>it=plantmenu.iterator();it.hasNext(); ){
            Plant plant=it.next();
            plant.accept(expLivingVisitor);
        }

        // 扩展对象 Extension objects 模式
        AugmentedHoe augmentedHoe = new AugmentedHoe();


        //使用 代理（Proxy）模式
        System.out.println("======== 使用 代理Proxy 模式 ========");
        OwnerProxy ownerProxy = new OwnerProxy();
        System.out.println("成功创建农产主代理@"+ownerProxy.hashCode());
        System.out.println("通过代理@"+ownerProxy.hashCode()+"读取owner的财产总额。");
        ownerProxy.getMoney();
        System.out.println("尝试通过代理@"+ownerProxy.hashCode()+"帮助owner消费1300元。");
        ownerProxy.reduceMoney(1300);
        System.out.println("尝试通过代理@"+ownerProxy.hashCode()+"帮助owner消费300元。");
        ownerProxy.reduceMoney(300);

        //使用 装饰器（Decorator）模式
        System.out.println("======== 使用 装饰器Decorator 模式 ========");

        //animal decorator test
        System.out.println("动物装饰器：");
        TableChicken tc = new TableChicken();
        System.out.println("生成一只普通的tableChicken@"+tc.hashCode()+"，价值"+tc.getValue()+"元。");
        FreshDecorator d_tc = new FreshDecorator(tc);
        System.out.println("对tableChicken@"+tc.hashCode()+"进行新鲜装饰器@"+d_tc.hashCode()+"处理后，价值"+d_tc.getValue()+"元。");
        StaleDecorator d_sc = new StaleDecorator(tc);
        System.out.println("对tableChicken@"+tc.hashCode()+"进行陈腐装饰器@"+d_sc.hashCode()+"处理后，价值"+d_sc.getValue()+"元。");

        //plant decorator test
        System.out.println("植物装饰器：");
        Crop c = new Crop();
        System.out.println("生成一棵普通的crop@"+c.hashCode()+"，价值"+c.getValue()+"元。");
        OrganicDecorator d_oc = new OrganicDecorator(c);
        System.out.println("对crop@"+c.hashCode()+"进行有机蔬菜装饰器@"+d_oc.hashCode()+"处理后，价值"+d_oc.getValue()+"元。");
        TransgenosisDecorator d_tgc = new TransgenosisDecorator(c);
        System.out.println("对crop@"+c.hashCode()+"进行有机蔬菜装饰器@"+d_tgc.hashCode()+"处理后，价值"+d_tgc.getValue()+"元。");


        //使用 规约（Specification） 模式
        System.out.println("======== 使用 规约Specification 模式 ========");
        specification_test t = new specification_test();

        //系统结束时保存Farm
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
        //使用 数据访问对象（DAO） 模式
        System.out.println("======== 使用 DAO 模式 ========");
        FarmDao farmDao=new FarmDaoImpl();
        farmDao.updateFarm(farm);
        System.out.println("农场数据保存成功");
    }
}
