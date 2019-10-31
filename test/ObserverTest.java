import Observer.AnimalsObserver;
import Observer.Observable.TimeCounter;
import Observer.PlantsObserver;
import org.junit.Test;

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
