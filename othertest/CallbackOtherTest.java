import CallBack.ReduceMoneyCallback;
import Command.PurchaseCommand;
import Constant.Const;
import Farm.Owner;
import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import static org.junit.Assert.assertEquals;

public class CallbackOtherTest {

    private Owner owner;
    private double originalMoney;
    private int numToBuy;
    private PurchaseCommand purchaseCommand;

    @Before
    public void setUp() {
        System.out.println("======== 测试 Callback 模式 ========");
        owner = Owner.getInstance();
        originalMoney = owner.getMoney();
        numToBuy = 3;
        purchaseCommand = new PurchaseCommand(
            Const.NAME_TABLE_CHICKEN, numToBuy, new ReduceMoneyCallback(0));
    }

    @Test
    public void test() {
        purchaseCommand.execute();
        double moneyToPay = numToBuy*Const.VALUE_TABLE_CHICKEN;
        double moneyShouldBe = originalMoney - moneyToPay;
        double moneyAfterBuy = owner.getMoney();
        System.out.println("场主购买前拥有资金: " + originalMoney);
        System.out.println("场主购买需支付: " + moneyToPay);
        System.out.println("场主购买后拥有资金: " + moneyAfterBuy);
        assertEquals(moneyShouldBe, moneyAfterBuy, 0.000001);
    }
}
