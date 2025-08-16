package javaSDET;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_10 extends  Topic_09{
    //phạm vi toàn cục (class)
    String address;
    public Topic_10(String address, String name) {
        super(name);
        this.address = address;
    }

    //Khi chạy đa luồng và gọi đến hàm này thì bắt buộc phải chạy theo thứ tự
    public synchronized WebDriver getDriver() {
        return new FirefoxDriver();
    }
}
