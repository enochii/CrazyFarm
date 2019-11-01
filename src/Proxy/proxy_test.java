package Proxy;


public class proxy_test {
	public static void main(String[] args) {
		OwnerProxy ownerProxy = new OwnerProxy();
		System.out.println("测试1：测试代理获取owner的财产。");
		ownerProxy.getMoney();
		System.out.println("测试2：测试owner通过代理花钱，且钱不够的情况。");
		ownerProxy.reduceMoney(1300);
		System.out.println("测试3：测试owner通过代理花钱，钱足够的情况。");
		ownerProxy.reduceMoney(300);
	}
}
