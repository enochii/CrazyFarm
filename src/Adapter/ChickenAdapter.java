package Adapter;

import Livings.Animals.Chicken.Chicken;
import Livings.Animals.Chicken.TableChicken;
import Livings.Animals.Duck.Duck;

/*
 * 鸡的适配器，把鸡叫gobble适配成quack
 */
public class ChickenAdapter extends Duck {

    private Chicken _chicken;

    /*
     * @param : chicken，被适配的鸡
     * 适配器的构造函数
     */
    public ChickenAdapter(Chicken chicken){
        this._chicken = chicken;
    }

    /*
     * 鸡模仿鸭叫
     */
    @Override
    public void quack(){
        System.out.print("Quack From A Children: ");
        _chicken.gobble();
    }

    /*
     * 测试函数
     */
    public static void main(){
        Duck fakeDuck = new ChickenAdapter(new TableChicken());
        fakeDuck.quack();
    }
}
