package Farm;

import SolveStarvation.OwnerSolveStarvation;
import SolveStarvation.Starvation;

public class Owner implements MoneyGetter {
    private double money;
    private static Owner instance = new Owner();

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
}
