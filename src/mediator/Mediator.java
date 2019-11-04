package mediator;

import Farm.Farm;

import java.io.Serializable;

public interface Mediator extends Serializable{
    public abstract void createColleagues();
    public abstract void colleagueChanged();
}
