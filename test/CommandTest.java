import CallBack.ReduceMoneyCallback;
import Command.Command;
import Command.PurchaseCommand;

import org.junit.Test;

/**
 * @program: crazyfarm->CommandTest
 * @description: 命令模式的测试类
 * @author: jh
 * @create: 2019-11-05 11:47
 **/

public class CommandTest {

    @Test
    public void test(){
        System.out.println("======== 测试 Command 模式 ========");
        String kind = "TableChicken";
        int number = 3;
        ReduceMoneyCallback reduceMoneyCallback = new ReduceMoneyCallback(0);
        Command purchaseCmd = new PurchaseCommand(kind, number, reduceMoneyCallback);
        System.out.println("PurchaseCommand : " + purchaseCmd.hashCode() +  " :execute: execute the purchase command");
        purchaseCmd.execute();

    }
}
