import Livings.Plants.Plant;
import Observer.AnimalsObserver;
import Observer.Observable.TimeCounter;
import Observer.PlantsObserver;
import org.junit.Before;
import org.junit.Test;

/**
 * @className: ObserverOtherTest
 * @description:
 * @designPattern:
 * @date: 2019/11/12 21:52
 */
public class ObserverOtherTest {
    private TimeCounter timeCounter;
    private AnimalsObserver animalsObserver;
    private PlantsObserver plantsObserver;
    @Before
    public void setUp() {
        System.out.println("======== 测试 Observer 模式 ========");
        timeCounter= new TimeCounter();
        animalsObserver=new AnimalsObserver();
        plantsObserver=new PlantsObserver();
    }

    @Test
    public void testForObserver() {
        System.out.println("\n测试动物观察者：");
        timeCounter.addObserver(animalsObserver);
        for(int i=1;i<2;++i) {
            timeCounter.updateTime();
            System.out.println("当前时间是："+timeCounter.getCurrentTime());
        }
        System.out.println("\n测试植物观察者：");
        timeCounter.addObserver(plantsObserver);
        for(int i=1;i<2;++i) {
            timeCounter.updateTime();
            System.out.println("PlantMediator has been initialized \n======== 使用 Mediator 模式 ========\nMediator : 1345636186 :colleagueChanged: updare the Plant EXP ");
            System.out.println("当前时间是："+timeCounter.getCurrentTime());
        }
    }
}
