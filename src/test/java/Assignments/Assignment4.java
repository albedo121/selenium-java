package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Assignment4 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();  //Open chrome browser
        driver.manage().window().maximize();  //Go into full screen mode
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Implicit wait of 10s

        //SCRIPT BEGINS FROM HERE.....................................................
        String url = "https://the-internet.herokuapp.com/";
        driver.get(url);

        //Click on 'Multiple Windows' text
        driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();

        //Click on 'Click Here' link
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        //Get both window handles
        Set<String> tabs = driver.getWindowHandles();
        Iterator<String> It = tabs.iterator();
        String parentID = It.next();
        String childID = It.next();

        //Switch to 2nd tab
        driver.switchTo().window(childID);

        //Get text and print it
        System.out.println(driver.findElement(By.className("example")).getText());

        //Return to 1st tab
        driver.switchTo().window(parentID);

        //Get text and print it
        System.out.println(driver.findElement(By.tagName("h3")).getText());
    }
}
