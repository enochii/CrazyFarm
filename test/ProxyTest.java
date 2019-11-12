import Proxy.OwnerProxy;
import org.junit.Test;

/**
 * @program: crazyfarm->ProxyTest
 * @description: 这是代理模式的测试类
 * @author: jh
 * @create: 2019-11-05 18:52
 **/

public class ProxyTest {

    @Test
    public void test(){
        OwnerProxy ownerProxy = new OwnerProxy();
        System.out.println("测试1：测试代理获取owner的财产。");
        ownerProxy.getMoney();
        System.out.println("测试2：测试owner通过代理花钱，且钱不够的情况。");
        ownerProxy.reduceMoney(1300);
        System.out.println("测试3：测试owner通过代理花钱，钱足够的情况。");
        ownerProxy.reduceMoney(300);
    }
}
