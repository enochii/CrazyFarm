package Farm;

import Builder.FarmerMultipleton;
import Dao.FarmDao;
import Dao.FarmDaoImpl;
import Constant.Const;
import Livings.Animals.Animal;
import Livings.Animals.Chicken.TableChicken;
import Livings.Plants.Crop;
import Livings.Plants.Plant;
import mediator.AnimalMediator;
import mediator.PlantMediator;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//import javafx.scene.control.Menu;

/**
 * 农场类，在这里进行初始化工作
 */
public class Farm implements Serializable {
    /**
     * 动植物的菜单
     */
    private Menu<Animal> _animalMenu;
    private Menu<Plant> _plantMenu;
    //public List<Farmer> farmers = new ArrayList<Farmer>();

    private AnimalMediator _animalMediator;
    private PlantMediator _plantMediator;

    /**
     * 初始库房和食槽的粮食数量
     */
    public int wareHouse = 200;
    public int foodCourt = 100;

    //农民的菜单
    private Menu<FarmerMultipleton> _farmerMultipletonMenu;
    private Owner _owner;  //农场主

    /**
     * 构造函数
     */
    private Farm(){
        this._animalMenu = new Menu<Animal>();
        this._plantMenu = new Menu<Plant>();
        this._farmerMultipletonMenu = new Menu<FarmerMultipleton>();
//        this._animalMediator = new AnimalMediator();
//        this._plantMediator = new PlantMediator();
    }

    static Farm _instance;

    /**
     * @return : 农场实例
     * 获取 [农场] 的全局唯一实例，这里用到了单例模式
     */
    public static Farm getInstance() {
        if(_instance == null) {
            FarmDao farmDao=new FarmDaoImpl();
            if( (_instance = farmDao.getFarm()) == null) {

                //debug
                _instance = Farm.init();
                //_instance = new Farm();
               // System.out.println(_instance.getAnimalMenu());
//                _instance._animalMediator.setFarm(_instance);
                //初始化一个空农场,并存储到本地中
//                _instance = new Farm();
//                System.out.println("初始化农场数据");
                farmDao.updateFarm(_instance);
            }
        }
        if(_instance._animalMenu == null){
            System.out.println("_animalMenu is null in json");
        }
        return _instance;
    }

    /**
     * @return : 动物菜单
     * 获取动物菜单
     */
    public Menu<Animal> getAnimalMenu(){
        return _animalMenu;
    }
    /**
     * @return : 植物菜单
     * 获取动物菜单
     */
    public Menu<Plant> getPlantMenu(){
        return _plantMenu;
    }



    /**
     * @return 空闲的喂食农民
     */
    public Farmer getFreeFarmer(){
        Iterator<FarmerMultipleton> farmer_iter = _farmerMultipletonMenu.iterator();
        Farmer free_farmer = null;
        while (farmer_iter.hasNext()){
            Farmer farmer = farmer_iter.next().farmer;
            if(!farmer.getWorkStatus() && farmer.getWorkType()== Const.WorkType.FEED){
                free_farmer = farmer;
                break;
            }
        }
        return free_farmer;
    }

    /**
     * @return 空闲的无工具农民
     */
    public Farmer getFreeSpareFarmer(){
        Iterator<FarmerMultipleton> farmer_iter = _farmerMultipletonMenu.iterator();
        Farmer free_farmer = null;
        while (farmer_iter.hasNext()){
            Farmer farmer = farmer_iter.next().farmer;
            if(!farmer.getWorkStatus() && farmer.getWorkType()== Const.WorkType.SPARE){
                free_farmer = farmer;
                break;
            }
        }
        return free_farmer;
    }

    /**
     * 获取中介者
     */
    public AnimalMediator getAnimalMediator(){
        if (_animalMediator == null){
            _animalMediator = new AnimalMediator();
        }
        return _animalMediator;
    }

    public Menu<FarmerMultipleton> getFarmerMenu(){
        return _farmerMultipletonMenu;
    }

//    //测试中介者模式
//    public void addAnimal(Animal animal){
//        this._animalMenu.add(animal);
//    }
//
//    public void addFarmer(Farmer farmer){
//        this._farmerMenu.add(farmer);
//    }

    //获取农场动物中介者

    //初始化农场
    public static Farm init(){
        Farm farm = new Farm();


        for(int i = 0; i < 2; i++){
            TableChicken tempChicken = new TableChicken();
            farm.getAnimalMenu().add(tempChicken);
        }

        for(int i = 0; i < 8; i++){
            Crop tempCorp = new Crop();
            farm.getPlantMenu().add(tempCorp);
        }

        farm.getFarmerMenu().add(FarmerMultipleton.getCultivateInstance());
        farm.getFarmerMenu().add(FarmerMultipleton.getFeedInstance());
        farm.getFarmerMenu().add(FarmerMultipleton.getSpareInstance());
        return farm;

    }

    public void addMediatorForAll(){
        Iterator<Animal> animal_it = getAnimalMenu().iterator();
        while(animal_it.hasNext()){
            animal_it.next().setMediator(_animalMediator);
        }

        Iterator<Plant> plant_it = getPlantMenu().iterator();
        while(plant_it.hasNext()){
            plant_it.next().setMediator(_plantMediator);
        }

    }

    public void setMediatorForFarm(AnimalMediator animalMediator, PlantMediator plantMediator){
        this._animalMediator = animalMediator;
        this._plantMediator = plantMediator;
    }

//    public Owner getOwner(){
//        return owner;
//    }

    public void setOwnerForFarm(Owner owner){
        this._owner = owner;
    }

}
