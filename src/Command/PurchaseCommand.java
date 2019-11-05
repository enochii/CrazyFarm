package Command;

import CallBack.MoneyCallback;
import Constant.Const;
import Farm.Farm;
import Livings.Animals.Animal;
import Livings.Animals.Chicken.TableChicken;
import Livings.Animals.Duck.SmallYellowDuck;
import Livings.Plants.Crop;
import Livings.Plants.Plant;

/**
 * 购买的命令类
 */
public class PurchaseCommand implements Command {
    String _purchaseType;
    int _number;
    private MoneyCallback _reduceMoneyCallBack;
    private Crop _cropSingleton = new Crop();

    public PurchaseCommand(String animalType, int number, MoneyCallback callBack) {
        _purchaseType = animalType;
        _number = number;
        _reduceMoneyCallBack = callBack;
    }

    /**
     * 购买命令类的执行函数
     */
    public void execute() {
        System.out.println("======== 使用 Command 模式 ========");
        System.out.println("PurchaseCommand : " + this.hashCode() +  " :execute: execute purchase command");
        Farm farm = Farm.getInstance();
        if(_purchaseType.equals(Const.NAME_TABLE_CHICKEN)){
            for(int i = 0; i < _number; i++) {
                Animal animal = new TableChicken();
                farm.getAnimalMenu().add(animal);
                _reduceMoneyCallBack.setMoney(animal.getValue());
                _reduceMoneyCallBack.call();
            }
        }
        else if(_purchaseType.equals(Const.NAME_YELLOW_DUCK)){
            for(int i = 0; i < _number; i++){
                Animal animal = new SmallYellowDuck();
                farm.getAnimalMenu().add(animal);
                _reduceMoneyCallBack.setMoney(animal.getValue());
                _reduceMoneyCallBack.call();
            }
        }
        else if(_purchaseType.equals(Const.NAME_CROP))
        {
            for(int i = 0; i < _number; i++){
                farm.getPlantMenu().add(_cropSingleton.clone());

            }
        }
    }
}
