package Assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assignment8 {
    public static void main(String[] args) {
        //Initial Setup
        WebDriver driver = new ChromeDriver();  //Invoke chrome browser
        driver.manage().window().maximize();  //Maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Implicit wait of 10s

        //BEGIN SCRIPT FROM HERE---------------------------------------------------
        String url = "https://rahulshettyacademy.com/AutomationPractice/";
        driver.get(url);


    }
}
