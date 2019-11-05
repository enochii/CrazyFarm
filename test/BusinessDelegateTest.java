import BusinessDelegate.*;
import Constant.Const;
import org.junit.Test;

public class BusinessDelegateTest {
    @Test
    public void test() {
        System.out.println("测试业务代表模式：");

        BusinessDelegate businessDelegate = new BusinessDelegate();
        Client client = new Client(businessDelegate);

        System.out.println("");
        businessDelegate.setBusinessService(Const.SERVICE_CNT_FARMER);
        client.doTask();

        System.out.println("");
        businessDelegate.setBusinessService(Const.SERVICE_DISPLAY_PLANT);
        client.doTask();
    }
}
