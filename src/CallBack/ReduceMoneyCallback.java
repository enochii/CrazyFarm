package CallBack;

import Farm.Owner;

public class ReduceMoneyCallback implements MoneyCallback {

    private double _reduceMoney;

    public ReduceMoneyCallback(double reduceMoney) {
        this._reduceMoney = reduceMoney;
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
        Owner owner = Owner.getInstance();
        if (!owner.reduceMoney(_reduceMoney)) {
            throw new RuntimeException("the owner doesn't have enough money");
        }
    }

}
