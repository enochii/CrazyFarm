package CallBack;

import Proxy.OwnerProxy;

/**
 * 回调(Callback)模式
 * 通过回调来扣除场主的资金
 */
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

    /**
     * 回调模式的调用函数
     * 调用此函数完成扣除资金回调
     */
    @Override
    public void call() {
        if (!_ownerProxy.reduceMoney(_reduceMoney)) {
            throw new RuntimeException("the owner doesn't have enough money");
        }
    }

}
