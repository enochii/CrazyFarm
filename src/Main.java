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
import Livings.Animals.Chicken.TableChicken;
import MVC.FarmerController;
import MVC.FarmerView;
import Memento.CropStateMemento;
import Observer.AnimalsObserver;
import Observer.Observable.TimeCounter;
import Observer.PlantsObserver;
import Tools.Extension.AugmentedHoe;
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

        // 扩展对象 Extension objects 模式
        AugmentedHoe augmentedHoe = new AugmentedHoe();

        //系统结束时保存Farm
        FarmDao farmDao=new FarmDaoImpl();
        farmDao.updateFarm(farm);
    }
}
