import CallBack.ReduceMoneyCallback;
import Command.PurchaseCommand;
import Constant.Const;
import Farm.Owner;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CallbackTest {
    @Test
    public void test() {
        Owner owner = Owner.getInstance();
        double originalMoney = owner.getMoney();
        int numToBuy = 3;
        PurchaseCommand purchaseCommand = new PurchaseCommand(
            Const.NAME_TABLE_CHICKEN, numToBuy, new ReduceMoneyCallback(0));
        purchaseCommand.execute();
        double moneyShouldBe = originalMoney - numToBuy*Const.VALUE_TABLE_CHICKEN;
        assertEquals(moneyShouldBe, owner.getMoney(), 0.000001);
    }
}
