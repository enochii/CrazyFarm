package Farm;

import Builder.FarmerMultipleton;
import Dao.FarmDao;
import Dao.FarmDaoImpl;
import Constant.Const;
import Livings.Animals.Animal;
import Livings.Plants.Plant;
import mediator.AnimalMediator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//import javafx.scene.control.Menu;

/**
 * 农场类，在这里进行初始化工作
 */
public class Farm {
    /**
     * 动植物的菜单
     */
    private Menu<Animal> _animalMenu;
    private Menu<Plant> _plantMenu;
    //public List<Farmer> farmers = new ArrayList<Farmer>();

    private AnimalMediator _animalMediator;

    /**
     * 初始库房和食槽的粮食数量
     */
    public int wareHouse = 200;
    public int foodCourt = 100;

    //农民的菜单
    private Menu<FarmerMultipleton> _farmerMultipletonMenu;


    /**
     * 构造函数
     */
    private Farm(){
        this._animalMenu = new Menu<Animal>();
        this._plantMenu = new Menu<Plant>();
<<<<<<< HEAD
        this._farmerMenu = new Menu<Farmer>();

        //初始化4个农民
        for(int i = 0; i < 4; i++){
            int tempAge = 30;
            String tempName = "Farmer" + i;
            Farmer tempFarmer = new Farmer(tempAge, tempName);
            _farmerMenu.add(tempFarmer);
        }
=======
        this._farmerMultipletonMenu = new Menu<FarmerMultipleton>();
>>>>>>> master
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
                //初始化一个空农场,并存储到本地中
                _instance = new Farm();
                System.out.println("初始化农场数据");
                farmDao.updateFarm(_instance);
            }
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
     * @return 空闲的农民
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
     * 获取中介者
     */
    public AnimalMediator getAnimalMediator(){
        if (_animalMediator == null){
            _animalMediator = new AnimalMediator();
        }
        return _animalMediator;
    }

<<<<<<< HEAD
    /**
     * 获取农民的列表.
     *
     * @return the menu
     */
    public Menu<Farmer> getFarmerMenu(){
        return _farmerMenu;
=======
    public Menu<FarmerMultipleton> getFarmerMenu(){
        return _farmerMultipletonMenu;
>>>>>>> master
    }

//    //测试中介者模式
//    public void addAnimal(Animal animal){
//        this._animalMenu.add(animal);
//    }
//
//    public void addFarmer(Farmer farmer){
//        this._farmerMenu.add(farmer);
//    }
}
