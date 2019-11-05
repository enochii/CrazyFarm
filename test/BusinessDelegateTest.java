import BusinessDelegate.*;
import Constant.Const;
import org.junit.Test;

public class BusinessDelegateTest {
    @Test
    public void test() {
        System.out.println("测试业务代表模式：");
        System.out.println("提示：执行业务服务需要获得农场单例实例。根据单例模式，第一次获取实例时会执行农场初始化操作。");

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
