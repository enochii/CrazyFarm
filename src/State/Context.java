package State;

public interface Context {

    public abstract void setClock(int currentTime);
    public abstract void changeState(State state);
    public abstract void getFed(int hour);

}
