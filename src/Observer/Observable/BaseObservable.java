package Observer.Observable;

import Observer.BaseObserver;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The type Base observable.
 *
 * @className: Observable
 * @author: OY
 * @description:
 * @designPattern: Observer
 * @date: 18 :25 2019/10/25
 */
public class BaseObservable {
    /**
     * The Observers contins all the observers.
     */
    protected Collection<BaseObserver> observers;

    /**
     * Instantiates a new Base observable.
     */
    BaseObservable(){
        observers=new ArrayList<BaseObserver>();
    }

    /**
     * Adds an observer to the set of observers for this object.
     * @param o an observer to be added.
     * @return {@code true} if an observer was added as a result of this call
     */
    public boolean addObserver(BaseObserver o){
        return observers.add(o);
    }

    /**
     * Deletes an observer from the set of observers of this object.
     * @param o an observer to be deleted.
     * @return {@code true} if an observer was removed as a result of this call
     */
    public boolean deleteObserver(BaseObserver o){
        return observers.remove(o);
    }

    /**
     * If this object has changed, notify all of its observers
     */
    public void notifyAllObservers(){
        for (BaseObserver o:observers) {
            o.update(this);
        }
    }
}
