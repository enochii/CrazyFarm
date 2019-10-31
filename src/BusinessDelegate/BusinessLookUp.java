package BusinessDelegate;

import BusinessDelegate.Business.BusinessService;
import BusinessDelegate.Business.CountFarmerService;
import BusinessDelegate.Business.DisplayPlantService;
import Constant.Const;

/**
 * Responsible for obtaining the relevant business implementation and
 * providing the access of business objects to business delegate objects.
 * @className: BusinessLookUp
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 12:31 下午 2019/10/31
 */
public class BusinessLookUp {
    public BusinessService getBusinessService(String serviceType) {
        if (serviceType.equalsIgnoreCase(Const.SERVICE_CNT_FARMER)) {
            return new CountFarmerService();
        }
        else {
            return new DisplayPlantService();
        }
    }
}
