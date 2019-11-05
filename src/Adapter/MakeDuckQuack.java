package Adapter;

import Livings.Animals.Duck.Duck;

/**
 * @author : SCH001
 * @description : 检验Adapter是否进行了正确的封装
 */
public class MakeDuckQuack {
    /**
     * @description 这里必须使用一只Duck的实例，直接传进一只Chicken会造成编译错误
     * @param duck
     */
    public static void makeDuckQuack(Duck duck){
        System.out.println("======== 使用 适配器 Adapter模式 =======");
        System.out.println("非鸭勿扰！");
        duck.quack();
    }
}
