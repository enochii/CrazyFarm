import BusinessDelegate.BusinessDelegate;
import BusinessDelegate.Client;
import Constant.Const;
import org.junit.Before;
import org.junit.Test;

/**
 * @className: BusinessDelegateOtherTest
 * @description:
 * @designPattern:
 * @date: 1:40 下午 2019/11/12
 */
public class BusinessDelegateOtherTest {

    private BusinessDelegate businessDelegate;
    private Client client;

    @Before
    public void setUp() {
        System.out.println("======== 测试 Business Delegate 模式 ========");
        businessDelegate = new BusinessDelegate();
        client = new Client(businessDelegate);
    }

    @Test
    public void testForBusinessDelegate() {
        businessDelegate.setBusinessService(Const.SERVICE_CNT_FARMER);
        client.doTask();

        businessDelegate.setBusinessService(Const.SERVICE_DISPLAY_PLANT);
        client.doTask();
    }
}
