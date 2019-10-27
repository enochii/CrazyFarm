package Observer.Observable;

/**
 * the subclass of BaseObservable{@link BaseObservable}
 * it records the current time of the system
 * it will notify all observers when the current time increase
 * @className: TimeCounter
 * @author: OY
 * @description: the subclass of BaseObservable
 * @designPattern: Observer
 * @date: 18:34 2019/10/25
 */
public class TimeCounter extends BaseObservable {
    private int currentTime;

    /**
     * Increase the current time firstly and then notify all the observers who care about time update.
     * @return the current time
     */
    int updateTime() {
        currentTime++;
        notifyAllObservers();
        return currentTime;
    }
}
