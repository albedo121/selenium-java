package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assignment5 {
    public static void main(String[] args) {

        //Initial Setup
        WebDriver driver = new ChromeDriver();  //Open chrome driver
        driver.manage().window().maximize();  //Maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  //Implicit wait of 10s

        //SCRIPT BEGINS FROM HERE--------------------------------------------------------
        String url = "https://the-internet.herokuapp.com/";
        driver.get(url);

        driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();  //Find Nested Frames link and click

        WebElement frame_top = driver.findElement(By.cssSelector("frame[name='frame-top']"));   //Find Top frame
        driver.switchTo().frame(frame_top);  //Switch to top frame

        WebElement frame_middle = driver.findElement(By.cssSelector("frame[name='frame-middle']"));  //Find middle frame
        driver.switchTo().frame(frame_middle);  //Switch to middle frame

        System.out.println(driver.findElement(By.id("content")).getText());

    }
}
