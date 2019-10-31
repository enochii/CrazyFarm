package BusinessDelegate;

import BusinessDelegate.Business.BusinessService;

/**
 * An entry class for Client that provides access to business service.
 * @className: BusinessDelegate
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 12:41 下午 2019/10/31
 */
public class BusinessDelegate {
    private BusinessLookUp lookupService = new BusinessLookUp();
    private BusinessService businessService;
    private String serviceType;

    public void setBusinessService(String serviceType) {
        this.serviceType = serviceType;
    }

    public void doTask() {
        businessService = lookupService.getBusinessService(serviceType);
        businessService.doProcessing();
    }
}
