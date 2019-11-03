package CallBack;

import Proxy.OwnerProxy;

public class ReduceMoneyCallback implements MoneyCallback {

    private double _reduceMoney;
    private OwnerProxy _ownerProxy;

    public ReduceMoneyCallback(double reduceMoney) {
        this._reduceMoney = reduceMoney;
        this._ownerProxy = new OwnerProxy();
    }

    /**
     * reset the money to reduce
     * @param money the money to reduce
     */
    @Override
    public void setMoney(double money) {
        _reduceMoney = money;
    }

    @Override
    public void call() {
        if (!_ownerProxy.reduceMoney(_reduceMoney)) {
            throw new RuntimeException("the owner doesn't have enough money");
        }
    }

}
