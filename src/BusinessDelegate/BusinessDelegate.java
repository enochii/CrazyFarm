package BusinessDelegate;

import BusinessDelegate.Business.BusinessService;

/**
 * An entry class for Client that provides access to business service.
 * 为终端提供具体业务服务访问的入口类。
 *
 * @className: BusinessDelegate
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 12 :41 下午 2019/10/31
 */
public class BusinessDelegate {
    private BusinessLookUp lookupService = new BusinessLookUp();
    private BusinessService businessService;
    private String serviceType;

    /**
     * Sets business service.
     * 设置业务服务类型。
     *
     * @param serviceType the service type
     */
    public void setBusinessService(String serviceType) {
        this.serviceType = serviceType;
    }

    /**
     * Do task.
     * 执行业务服务任务。
     */
    public void doTask() {
        businessService = lookupService.getBusinessService(serviceType);
        businessService.doProcessing();
    }
}
