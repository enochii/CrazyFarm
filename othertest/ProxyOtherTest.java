import Farm.Owner;
import Proxy.OwnerProxy;
import org.junit.Before;
import org.junit.Test;

public class ProxyOtherTest {
	private OwnerProxy ownerProxy;

	@Before
	public void setUp(){
		System.out.println("======== 使用 Proxy 模式 ========");
		ownerProxy = new OwnerProxy();
	}

	@Test
	public void testForProxy(){
		//用代理获取owner的金钱
		ownerProxy.getMoney();
		//用代理帮助owner消费
		ownerProxy.reduceMoney(1600);
		ownerProxy.reduceMoney(600);
	}
}
