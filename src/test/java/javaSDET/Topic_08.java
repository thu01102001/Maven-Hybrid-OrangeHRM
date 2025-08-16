package javaSDET;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Topic_08 {
    //Phạm vi static là chia sẻ toàn bộ system
    static String name = "Automation";

    //non static
    String address = "12 add";

    //hằng số
    static final String AGE = "19";

    @Test
    public void TC_01() {
        Topic_08 tp = new Topic_08();
        tp.address = "";

        //thuộc phạm vi class
        Topic_08.name = "";

        String osName = "Windows 11";
        String separator = null;
        WebDriver driver;

        //Condition Statement
        //if-else
        if(osName.contains("Windows")) {
            separator = "\\";
        } else {
            separator = "/";
        }

        String browserName = "Chrome";
        //switch-case
        switch (browserName) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is invalid");
        }

        //Lop Statement
        int studentNumber = 10;
        //Classic for
        //for
        for (int i = 0; i < studentNumber; i++) {
            System.out.println(i);
        }

        for (int i = 0; i < studentNumber; i++) {
            if(i == 5) {
                System.out.println(i);
            }
        }

        List<String> stdName = new ArrayList<String>();
        //For-Each
        for (String std : stdName) {
            System.out.println(std);
        }

        //while - kiểm tra điều kiện trước
        int x = 0;
        while (x < studentNumber) {
            System.out.println(x);
            x++;
        }

        //do-while - làm trước kiểm tra điều kiện sau
        int z = 10;
        do {
            System.out.println(z);
            z++;
        } while (z < studentNumber);

        try {
            driver.findElement(By.cssSelector("")).isDisplayed();
        } catch (NoSuchElementException exception) {
            //Edge case
            System.out.println(exception.getMessage());
        }

    }

}
