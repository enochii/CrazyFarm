package Farm;

import Livings.Animals.Animal;
import Livings.Plants.Plant;
//import javafx.scene.control.Menu;

/*
 * 农场类，在这里进行初始化工作
 */
public class Farm {
    //动植物的菜单
    private Menu<Animal> _animalMenu;
    private Menu<Plant> _plantMenu;

    /**
     * 构造函数
     */
    private Farm(){
        this._animalMenu = new Menu<Animal>();
        this._plantMenu = new Menu<Plant>();
    }

    static Farm _instance;

    /**
     * @return : 农场实例
     * 获取 [农场] 的全局唯一实例，这里用到了单例模式
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
    /*
     * @return : 植物菜单
     * 获取动物菜单
     */
    public Menu<Plant> getPlantMenu(){
        return _plantMenu;
    }
}
