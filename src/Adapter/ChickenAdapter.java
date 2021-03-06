package Adapter;

import Constant.Const;
import Livings.Animals.Chicken.Chicken;
import Livings.Animals.Chicken.TableChicken;
import Livings.Animals.Duck.Duck;
import State.State;

/**
 * 鸡的适配器，把鸡叫gobble适配成quack
 * 持有对真正的鸡实例的引用，真实的功能函数则转发到鸡处理
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

    @Override
    public String getName(){
        return _chicken.getName();
    }

    @Override
    public double getValue(){
        return _chicken.getValue();
    }

    /**
     * @description 适配器会转发逻辑给真正的动物TableChicken
     *
     */
    @Override
    public void setClock(int currentTime){
        _chicken.setClock(currentTime);
    }
    @Override
    public void changeState(State state){
        _chicken.changeState(state);
    }

    @Override
    public void setColleagueEnable(boolean enable) {
        _chicken.setColleagueEnable(enable);
    }

    @Override
    public void setColleagueUpdated(){
    }

    @Override
    public void makeSound() {
    }

    @Override
    public void makeEat() {}

    /*
     * 鸡模仿鸭叫
     */
    @Override
    public void quack(){
        System.out.print("Quack From A Children: ");
        _chicken.gobble();
    }

    /*
     * 内部测试函数
     */
    public static void main(){
        Duck fakeDuck = new ChickenAdapter(new TableChicken());
        fakeDuck.quack();
    }
}
