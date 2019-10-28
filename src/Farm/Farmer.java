package Farm;

import Command.Command;
import Command.SellCommand;
import Command.PurchaseCommand;
import Constant.Const;
import Constant.Const.WorkType;
import Livings.Animals.Animal;
import Tools.Tool;
import Tools.ToolPackage;

/*
 * 农民，完成各种农场的工作
 */

public class Farmer {
    private WorkType _type;           // 指定工作类型和背包，用于实现 Builder 模式
    private ToolPackage _bag;
    
    //农民的工作状态
    private boolean isWorking;


    public Farmer() {
        this._type = WorkType.SPARE;
        this._bag = new ToolPackage(2);
        this.isWorking = false;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(WorkType type) {this._type = type;}

    /**
     * Assign tool boolean.
     *
     * @param tool the tool
     * @return boolean isSuccessful
     */
    public boolean assignTool(Tool tool) {
        if (this._bag.isFull()) {
            return false;
        }
        else {
            this._bag.addTool(tool);
            return true;
        }
    }

    public String getWorkTypeString() {
        if ( _type== WorkType.SPARE ) return "Spare";
        else if ( _type== WorkType.CULTIVATE ) return "Cultivate";
        else if ( _type== WorkType.FEED ) return "Feed";
        else return "Invalid";
    }

    //TODO: 加上具体的Task
    public void doWork(){
        System.out.println("Implement  me!");
    }

    /**
     * Get work status boolean.
     *
     * @return the boolean
     */
    public boolean getWorkStatus(){
        return this.isWorking;
    }

    /**
     * Sell.
     *
     * @param animal the animal
     */
    public void sell(Animal animal){
        this.isWorking = true;
        Command cmd = new SellCommand(animal);
        cmd.execute();
        this.isWorking = false;
    }

    public void purchase(String kind, int number){
        this.isWorking = true;
        Command cmd = new PurchaseCommand(kind, number);
        cmd.execute();
        this.isWorking = false;
    }

}
