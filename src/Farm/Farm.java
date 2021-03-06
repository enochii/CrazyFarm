package Farm;

import Builder.FarmerMultipleton;
import Constant.Const;
import Dao.FarmDao;
import Dao.FarmDaoImpl;
import Livings.Animals.Animal;
import Livings.Animals.Chicken.TableChicken;
import Livings.Plants.Crop;
import Livings.Plants.Plant;
import mediator.AnimalMediator;
import mediator.PlantMediator;

import java.io.Serializable;
import java.util.Iterator;

//import sun.tools.jconsole.Tab;
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
    public int foodCourt = 20;

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

    //Mutexes for double checked locking
    private final static Object _mutex = new Object();

    /**
     * @return : 农场实例
     * 获取 [农场] 的全局唯一实例，这里用到了双重检查锁模式
     */
    public static Farm getInstance() {
        if(_instance == null) {
            //当多个线程同时发现instance为null时，除了第一个线程/进程，所有线程/进程只能到达这里
            synchronized (_mutex){
                //当第一个进程结束初始化后，所有进程来到这里发现已经初始化，直接返回
                //这样就避免了多个进程进行多次初始化
                if(_instance == null){
                    System.out.println("======== 使用双重检查锁 Double Checked Locking 模式=======");
                    System.out.println("农场初始化中");
                    //=================具体的初始化逻辑=================//
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
                    System.out.println("农场初始化成功！");
                }
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

    /**
     * 为农场中所有的动物添加中介者
     */
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

    /**
     * 为整个农场分配一个中介者
     */
    public void setMediatorForFarm(AnimalMediator animalMediator, PlantMediator plantMediator){
        this._animalMediator = animalMediator;
        this._plantMediator = plantMediator;
    }

//    public Owner getOwner(){
//        return owner;
//    }

    /**
     * 为整个农场分配一个农场主
     */
    public void setOwnerForFarm(Owner owner){
        this._owner = owner;
    }

}
