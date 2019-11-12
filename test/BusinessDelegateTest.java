import BusinessDelegate.*;
import Constant.Const;
import org.junit.Test;

public class BusinessDelegateTest {
    @Test
    public void test() {
        System.out.println("测试业务代表模式：");
        System.out.println("提示：执行业务服务需要获得农场单例实例。第一次获取实例时会执行农场初始化操作，\n此过程涉及双重检查锁模式、" +
                "建造者模式、私有类数据模式、抽象工厂模式、享元模式和桥接模式。\n此外，在执行具体的业务服务时，还会用到迭代器模式去访问农场内的农民和农作物。");

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
