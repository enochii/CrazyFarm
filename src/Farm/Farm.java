package Farm;

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
    public List<Farmer> farmers = new ArrayList<Farmer>();

    private AnimalMediator _animalMediator;

    /**
     * 初始库房和食槽的粮食数量
     */
    public int wareHouse = 200;
    public int foodCourt = 100;

    /**
     * 构造函数
     */
    private Farm(){
        this._animalMenu = new Menu<Animal>();
        this._plantMenu = new Menu<Plant>();
    }

    static Farm _instance;

    /**
     * @ return 农场实例
     * 获取 [农场] 的全局唯一实例，这里用到了单例模式
     * TODO : 是否可以认为用到了 Lazy Loading
     */
    public static Farm getInstance(){
        if(_instance == null){
            _instance = new Farm();
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
        Iterator<Farmer> farmer_iter = farmers.iterator();
        Farmer free_farmer = null;
        while (farmer_iter.hasNext()){
            Farmer farmer = farmer_iter.next();
            if(!farmer.getWorkStatus()){
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
}
