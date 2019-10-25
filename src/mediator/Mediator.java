package mediator;

import Farm.Farm;

import java.io.Serializable;

public interface Mediator {
    public abstract void createColleagues(Farm farm);
    public abstract void ColleagueChanged();
}
