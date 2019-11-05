import Observer.AnimalsObserver;
import Observer.Observable.TimeCounter;
import Observer.PlantsObserver;
import org.junit.Test;
/**
 * @program: crazyfarm->ObserverTest
 * @description: 观察者模式的测试类
 * @author: oy
 * @create: 2019-11-04 16:42
 **/
public class ObserverTest {
    @Test
    public void test(){
        TimeCounter timeCounter= new TimeCounter();
        AnimalsObserver animalsObserver=new AnimalsObserver();
        PlantsObserver plantsObserver=new PlantsObserver();
        timeCounter.addObserver(animalsObserver);
        timeCounter.addObserver(plantsObserver);
        timeCounter.updateTime();
    }
}
