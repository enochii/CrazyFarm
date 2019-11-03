package Farm;

import CallBack.ReduceMoneyCallback;
import Command.Command;
import Command.SellCommand;
import Command.PurchaseCommand;

import SolveStarvation.FarmerSolveStarvation;
import SolveStarvation.Starvation;

import Constant.Const.WorkType;
import Livings.Animals.Animal;
import Tools.Tool;

import java.io.Serializable;

/**
 * 农民完成各种农场的工作
 */

public class Farmer implements Serializable {

    private FarmerData _farmerData;

    //无参构造函数
    public Farmer() {
        this._farmerData = new FarmerData();
    }

    //通过年龄和名字来初始化农民
    public Farmer(int age, String name){
        this._farmerData = new FarmerData(age, name);
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(WorkType type) {
        _farmerData.setType(type);
    }

    /**
     * Assign tool boolean.
     *
     * @param tool the tool
     * @return boolean isSuccessful
     */
    public boolean assignTool(Tool tool) {
        return _farmerData.assignTool(tool);
    }

    public WorkType getWorkType() {
        return _farmerData.getWorkType();
    }

    /**
     * For TEST. Gets work type string.
     *
     * @return the work type string
     */
    public String getWorkTypeString() {
        return _farmerData.getWorkTypeString();
    }

    //TODO: 加上具体的Task
    public void doWork(){
        System.out.println("Implement  me!");
    }

    /**
     * 农民喂食
     */
    public boolean solveStarvation(FarmerSolveStarvation handler, Starvation starvation){
        int food_required = starvation._required_food_amount;
        if(handler._farm.wareHouse >= food_required){
            addFood(food_required);
            return true;
        }else {
            starvation._required_money_amount =  (food_required - handler._farm.wareHouse) / 10 * 0.1;
        }
        return false;
    }

    /**
     * 向食槽中添加食物
     */
    public void addFood(int amount){
        Farm farm = Farm.getInstance();

        while (amount>0){
            int per = amount >= 5 ? 5 : amount;
            farm.foodCourt += per;
            amount -= per;
            farm.wareHouse -= per;
            System.out.println("添加食物：5，食槽中食物总量：" + farm.foodCourt);
        }
    }

    /**
     * Get work status boolean.
     *
     * @return the boolean
     */
    public boolean getWorkStatus(){
        return _farmerData.getWorkStatus();
    }

    /**
     * Sell.
     *
     * @param animal the animal
     */
    public void sell(Animal animal){
        _farmerData.setWorkStatus(true);
        Command cmd = new SellCommand(animal);
        cmd.execute();
        _farmerData.setWorkStatus(false);
    }

    public void purchase(String kind, int number){
        _farmerData.setWorkStatus(true);
        ReduceMoneyCallback reduceMoneyCallback = new ReduceMoneyCallback(0);
        Command cmd = new PurchaseCommand(kind, number, reduceMoneyCallback);
        cmd.execute();
        System.out.println("a farmer is purchase " + kind);
        _farmerData.setWorkStatus(false);
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return _farmerData.getAge();
    }

    /**
     * Set age.
     *
     * @param age the age
     */
    public void setAge(int age){
        _farmerData.setAge(age);
    }

    /**
     * Get name string.
     *
     * @return the string
     */
    public String getName(){
        return _farmerData.getName();
    }

    /**
     * Set name.
     *
     * @param name the name
     */
    public void setName(String name){
        _farmerData.setName(name);
    }

}
