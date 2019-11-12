import CallBack.ReduceMoneyCallback;
import Command.Command;
import Constant.Const;
import Farm.Owner;
import org.junit.Before;
import org.junit.Test;
import Command.PurchaseCommand;
import static org.junit.Assert.*;

/**
 * @program: crazyfarm->CommandOtherTest
 * @description:
 * @create: 2019-11-12 14:25
 **/

public class CommandOtherTest {

    private String kind;
    private int number;
    private double initMoney;
    @Before
    public void init(){
        kind = "TableChicken";
        number= 3;
        //获取农场主最初的金钱
        initMoney = Owner.getInstance().getMoney();

    }
    @Test
    public void test(){
        System.out.println("======== 测试 Command 模式 ========");
        ReduceMoneyCallback reduceMoneyCallback = new ReduceMoneyCallback(0);
        Command purchaseCmd = new PurchaseCommand(kind, number, reduceMoneyCallback);
        //执行采购命令
        purchaseCmd.execute();
        //验证采购命令执行后金钱是否准确
        assertEquals((Owner.getInstance().getMoney()), initMoney - Const.VALUE_TABLE_CHICKEN * 3, 0.1);

    }

}
