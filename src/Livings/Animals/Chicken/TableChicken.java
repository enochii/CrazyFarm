package Livings.Animals.Chicken;

/*
 * 肉鸡类
 */
public class TableChicken extends Chicken{
    public TableChicken(){
        super.setName("TableChicken");
    }
    @Override
    public void gobble(){
        System.out.println("Table Children!");
    }
}
