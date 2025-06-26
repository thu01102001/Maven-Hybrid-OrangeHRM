package javaSDET;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ContructorMethod {
    public static void main(String[] args) {
        FirefoxDriver ffDriver;
        //Cách 1
        ffDriver = new FirefoxDriver();

        //Cách 2
        FirefoxOptions ffOption = new FirefoxOptions();
        ffDriver = new FirefoxDriver(ffOption);

        //Cách 3


    }
}
