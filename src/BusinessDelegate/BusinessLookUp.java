package BusinessDelegate;

import BusinessDelegate.Business.BusinessService;
import BusinessDelegate.Business.CountFarmerService;
import BusinessDelegate.Business.DisplayPlantService;
import Constant.Const;

/**
 * Responsible for obtaining the relevant business implementation and
 * providing the access of business objects to business delegate objects.
 * 负责获取相关业务实现和为代理提供业务对象的访问。
 *
 * @className: BusinessLookUp
 * @author: Leon
 * @description:
 * @designPattern:
 * @date: 12 :31 下午 2019/10/31
 */
public class BusinessLookUp {
    /**
     * Gets business service.
     * 根据业务服务类型获取具体的业务服务对象。
     *
     * @param serviceType the service type
     * @return the business service
     */
    public BusinessService getBusinessService(String serviceType) {
        if (serviceType.equalsIgnoreCase(Const.SERVICE_CNT_FARMER)) {
            return new CountFarmerService();
        }
        else {
            return new DisplayPlantService();
        }
    }
}
