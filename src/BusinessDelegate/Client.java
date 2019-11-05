package BusinessDelegate;

import Constant.Const;

/**
 * The Client is the terminal that the farmer uses to manage the farm.
 * It is the UI in the Business Delegate Pattern.
 * 供农场主使用的管理终端，农场主可以通过此终端获取管理农场的业务服务。
 * 由于实现了业务代理模式，终端中只保留表现层，对业务逻辑层进行了分离。
 *
 * @className: Client
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 12 :22 下午 2019/10/31
 */
public class Client {

    /**
     * The Business delegate.
     */
    BusinessDelegate _businessDelegate;

    /**
     * Instantiates a new Client.
     *
     * @param businessDelegate the business delegate
     */
    public Client(BusinessDelegate businessDelegate) {
        this._businessDelegate = businessDelegate;
    }

    /**
     * Do task.
     */
    public void doTask() {
        _businessDelegate.doTask();
    }
}

/**
 * The type Test business delegate.
 */
class TestBusinessDelegate {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        System.out.println("测试业务代表模式：");

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
