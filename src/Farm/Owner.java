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

    //农场主要派农民去买东西
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

    public void sell(Animal animal){
        Farmer spareFarmer = _farm.getFreeFarmer();
        if(spareFarmer != null){
            spareFarmer.sell(animal);
        }
    }

    public void setFarmForOwner(Farm farm)
    {
        this._farm = farm;
    }

}
