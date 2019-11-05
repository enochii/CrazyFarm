package Proxy;

import Farm.MoneyManager;
import Farm.Owner;

public class OwnerProxy implements MoneyManager {
	private Owner owner;
	private double money;

	public OwnerProxy(){
		owner = Owner.getInstance();
		money = owner.getMoney();
	};

	@Override
	public double getMoney() {
		System.out.println("代理：获知owner的财产有"+money+"元。");
		return money;
	}

	@Override
	public boolean reduceMoney(double m) {
		if (money < m) {
			System.out.println("代理：owner的财产不足"+m+"元，消费失败。");
			return false;
		}
		money -= m;
		Owner.getInstance().reduceMoney(m);
		System.out.println("代理：owner花了"+m+"元，余额为"+money+"元。");
		return true;
	}
}
