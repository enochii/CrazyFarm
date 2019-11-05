package Farm;

import Livings.Animals.Animal;
import SolveStarvation.OwnerSolveStarvation;
import SolveStarvation.Starvation;

import java.io.Serializable;


public class Owner implements MoneyManager, Serializable {
    private double money;
    private static Owner instance = new Owner();
    private Farm _farm;
    private Owner(){
        money = 1000;
    }

    public static Owner getInstance() {
        Owner temp = instance;
        if(temp == null){
            synchronized(Owner.class){
                temp = instance;
                if(temp == null){
                    instance = new Owner();
                    temp = instance;
                }
            }
        }
        return temp;
    }

    /**
     *农场主获取当前的金钱
     * @return 农场主的金钱
     */
    @Override
    public double getMoney(){
        return money;
    }

    /**
     *
     * @param ownerSolveStarvation 农场主负责类
     * @param starvation 需要解决的问题
     * @return 是否成功解决问题
     */
    public boolean solveStarvation(OwnerSolveStarvation ownerSolveStarvation, Starvation starvation ){
        int food_required = starvation._required_food_amount;
        if(this.getMoney() > starvation._required_money_amount){
            Farmer farmer = ownerSolveStarvation._farm.getFreeFarmer();
            if (farmer != null){
                money -= starvation._required_money_amount;
                ownerSolveStarvation._farm.wareHouse = starvation._required_food_amount;
                farmer.addFood(food_required);
                return true;
            }
        }
        System.out.println("There is not enough money.");
        return false;
    }

    /**
     * 农场主购买东西后减少钱
     * @param m the money to reduce
     * @return whether the reduction is successful
     */
    @Override
    public boolean reduceMoney(double m) {
        if (money < m) {
            return false;
        }
        money -= m;
        return true;
    }


    /**
     * 农场主派农民去购买
     * @param purchaseType 要购买的种类， number 要购买的数量
     * @return
     */
    public void purchase(String purchaseType, int number){
        if(this.getMoney() <= 0)
        {
            System.out.println("Sorry, Owner doesn't have enough money");
            return;
        }
        Farmer spareFarmer = _farm.getFreeSpareFarmer();
        if(spareFarmer != null){
            spareFarmer.purchase(purchaseType, number);
        }
    }

    /**
     * 农场主派农民去售卖动物
     * @param animal 要售卖的动物
     * @return
     */
    public void sell(Animal animal){
        Farmer spareFarmer = _farm.getFreeFarmer();
        if(spareFarmer != null){
            spareFarmer.sell(animal);
        }
    }

    /**
     * 为农场主设置一个管理的农场
     * @param farm 农场
     * @return
     */
    public void setFarmForOwner(Farm farm)
    {
        this._farm = farm;
    }

    /**
     * 为农场主增加金钱
     * @param money 赚到的钱
     */
    public void makeMoney(int money)
    {
        this.money += money;
    }

}
