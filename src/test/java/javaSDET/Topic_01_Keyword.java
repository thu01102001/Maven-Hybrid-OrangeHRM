package javaSDET;

//Class kế thừa class: extends
//Class kế thừa interface: implements
public class Topic_01_Keyword extends Topic_06 implements Topic_02{
    //Chỉ có non abstract method thôi
    //Không được có abstract method
    //Khởi tạo bình thường
    //Cho phép kế thừa

    //Data Type
    char c = 'A';
    byte bNumber = 10;
    short sNumber = 100;
    int iNumber = 1400;
    long lNumber = 23456843;
    float fNumber = 15.223F;
    double dNumber = 17.332D;
    boolean marialStatus = true;

    //Access Modifier
    private String studentName = "";
    String studentAddress = "";
    protected int studentAge = 30;
    public double studentPoint = 9.5;

    //Method
    private void TC_01() {

    }

    void TC_02() {

    }

    protected void TC_03() {

    }

    public void TC_04() {

    }

    @Override
    public void clearStudent() {

    }
}
