package Farm;

import Livings.Animals.Animal;
import Livings.Plants.Plant;

/*
 * 农场类，在这里进行初始化工作
 */
public class Farm {
    //动植物的菜单
    private Menu<Animal> _animalMenu;
    private Menu<Plant> _plantMenu;

    /*
     * 构造函数
     */
    private Farm(){
        this._animalMenu = new Menu<Animal>();
        this._plantMenu = new Menu<Plant>();
    }

    static Farm _instance;

    /*
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
}
