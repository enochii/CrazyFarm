package Command;

import Livings.Animals.Animal;

/**
 * @program: crazyfarm->SellCommand
 * @description: A command to sell animals
 * @author: jh
 * @create: 2019-10-27 20:09
 **/

public class SellCommand implements Command {

    protected Animal _animal;

    /**
     * 售卖动物的命令类instructor
     */
    public SellCommand(Animal animal){
        this._animal = animal;
    }

    /**
     * 售卖动物的命令类的执行函数
     */
    public void execute(){
        System.out.println("======== 使用 Command 模式 ========");
        System.out.println("SellCommand : " + this.hashCode() +  " :execute: execute sell command");
        _animal.doSell();
    }
}
