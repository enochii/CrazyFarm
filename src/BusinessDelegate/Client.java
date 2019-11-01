package BusinessDelegate;

import Constant.Const;

/**
 * The Client is the terminal that the farmer uses to manage the farm.
 * It is the UI in the Business Delegate Pattern.
 * @className: Client
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 12:22 下午 2019/10/31
 */
public class Client {

    BusinessDelegate _businessDelegate;

    public Client(BusinessDelegate businessDelegate) {
        this._businessDelegate = businessDelegate;
    }

    public void doTask() {
        _businessDelegate.doTask();
    }
}

class TestBusinessDelegate {

    public static void main(String[] args) {

        System.out.println("测试业务代表模式：");

        BusinessDelegate businessDelegate = new BusinessDelegate();
        Client client = new Client(businessDelegate);

        businessDelegate.setBusinessService(Const.SERVICE_CNT_FARMER);
        client.doTask();

        businessDelegate.setBusinessService(Const.SERVICE_DISPLAY_PLANT);
        client.doTask();

    }
}
