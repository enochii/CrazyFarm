package Observer;

import Observer.Observable.BaseObservable;

/**
 * The interface Base observer.
 *
 * @className: Observer
 * @author: OY
 * @description:  The interface Base observer.
 * @designPattern: Oberver
 * @date: 18 :24 2019/10/25
 */
public interface BaseObserver {
    /**
     * This method is called whenever the observed object is changed.
     * @param o the observed object
     */
    void update(BaseObservable o);
}
