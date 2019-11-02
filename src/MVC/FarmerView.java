package MVC;

/**
 * @program: crazyfarm->FarmerView
 * @description: 农民的视图类
 * @author: jh
 * @create: 2019-10-30 23:28
 **/

public class FarmerView {

    /**
     * 打印学生的详细信息
     *
     * @param studentName the student name
     * @param age         the age
     */
    public void printFarmerDetails(String studentName, int age){
        System.out.println("Farmer: ");
        System.out.println("Name: " + studentName);
        System.out.println("Age: " + age);
    }
}
