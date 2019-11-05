package Livings.Animals.Duck;

import Constant.Const;
import Farm.Farm;
import action.DuckEat;
import action.DuckSound;
import mediator.Mediator;
import Farm.Owner;
public class SmallYellowDuck extends Duck{
    private static double _value = Const.VALUE_YELLOW_DUCK;
    private static String _name = Const.NAME_YELLOW_DUCK;

    /**
     * @return 返回生物成熟后的价值
     */
    public double getValue(){
        return _value;
    }

    /**
     * @return 生物的名字
     */
    @Override
    public String getName(){
        return _name;
    }

    /**
     * 鸭叫
     */
    @Override
    public void quack(){
        makeSound();
    }

    /**
     * 构造函数，初始化中介者
     */
    public SmallYellowDuck(Mediator mediator){
        this.setMediator(mediator);
        this._appetite = 4;
    }

    /**
     * 随着时间改变动物的饥饿与否状态和成熟度
     */
    public void setClock(int currentTime){

        if(currentTime - _lastFedTime > 7){
            if(Farm.getInstance().foodCourt >= this._appetite)
            {
                System.out.println(Const.NAME_YELLOW_DUCK+ "is eating");
                this.getFed(currentTime);

            }

            else {
                _state.getHungryState(this);
            }

        }

        else{
            _state.gainExperience(this);
        }

        if(this._maturityRate >= 20){
            this._isMature = true;
        }


    }

    /**
     * 动物进食的动作
     */
    @Override
    public void makeEat() {
        new DuckEat().doAction();
    }

    /**
     * 动物发出声音
     */
    @Override
    public void makeSound() {
        new DuckSound().doAction();
    }

    @Override
    public String isMature() {
        if(_maturityRate > 4)
            _mature = Const.MATURE;
        return _mature;
    }

    /**
     * 动物接收中介者的命令
     */
    public void setColleagueEnable(boolean enable)
    {

    }

    /**
     * 动物向中介者报告
     */
    @Override
    public void setColleagueUpdated(){
        _animalMediator.colleagueChanged();

    }

    /**
     * 初始化鸭的食量
     */
    public SmallYellowDuck(){
        this._appetite = 4;
    }

    /**
     * 动物执行售卖
     */
    public void doSell() {
        if (this._isMature) {
            if (this.isSold) {
                System.out.println("This small yellow duck has been sold");
            } else {
                this.isSold = true;
                Owner.getInstance().makeMoney((int) (this.getValue()));
                Farm.getInstance().getAnimalMenu().erase(this);
                System.out.println("This small yellow duck has been sold successfully");
            }

        }
        else{
            System.out.println("This small yellow duck is not mature");
        }
    }
}
