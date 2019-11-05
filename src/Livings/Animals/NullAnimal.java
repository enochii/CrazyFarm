package Livings.Animals;

public class NullAnimal extends Animal {

    @Override
    public String getName() {
        System.out.printf("No available animal can be sold currently.");
        return "";
    }

    @Override
    public double getValue() {
        System.out.println("No available animal can be sold currently.");
        return 0;
    }

    @Override
    public void makeSound() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void makeEat() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setClock(int time) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setColleagueEnable(boolean enable) {
        throw new UnsupportedOperationException();
    }

}
