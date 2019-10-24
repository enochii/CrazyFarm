package Farm;

import Livings.Animals.Animal;
import Livings.Plants.Plant;

/*
 * 农场类，在这里进行初始化工作
 */
public class Farm {
    //动植物的菜单
    private Menu<Animal> animalMenu;
    private Menu<Plant> plantMenu;

    public Farm(){
        animalMenu = new Menu<Animal>();
        plantMenu = new Menu<Plant>();
    }
}
