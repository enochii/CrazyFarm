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
import Livings.Animals.Chicken.TableChicken;
import Livings.Plants.Plant;
import MVC.FarmerController;
import MVC.FarmerView;
import Memento.CropStateMemento;
import Observer.AnimalsObserver;
import Observer.Observable.TimeCounter;
import Observer.PlantsObserver;
import Visitor.ExpLivingVisitor;
import mediator.AnimalMediator;
import mediator.PlantMediator;

import java.util.Iterator;

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
            System.out.println("classname: (controller) :setFarmerAge: set a new age for a farmer");
            controller.setFarmerAge(30 + i);
            System.out.println("classname: (controller) :setFarmerAge: set a new name for a farmer");
            controller.setFarmerName(baseName + i);
            System.out.println("classname: (controller) : updateView: update and show the farmer's information");
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

        //使用 数据访问对象（DAO） 模式
        System.out.println("======== 使用 DAO 模式 ========");
        FarmDao farmDao=new FarmDaoImpl();
        farmDao.updateFarm(farm);
        System.out.println("农场数据保存成功");
    }
}
