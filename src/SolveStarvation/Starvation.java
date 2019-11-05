package SolveStarvation;

import java.text.DecimalFormat;

/**
 * 责任链(chain of responsibility)模式
 */
public class Starvation {
    public int _required_food_amount = 0;
    public double _required_money_amount = 0;

    /**
     *
     * @return 解决饥饿所需要的金钱和物资
     */
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("0.0");
        if(_required_money_amount==0){
            return "Lack of food amount: " + df.format(_required_food_amount) + ".";
        }
        else{
            return "Lack of food amount: " + df.format(_required_food_amount) + ". Need $"
                    + df.format(_required_money_amount) + " to buy additional food.";
        }
    }
}
