import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //Implicit wait of 10s

        //SCRIPT BEGINS FROM HERE-------------------------------------------------

        String url = "https://rahulshettyacademy.com/loginpagePractise/";
        driver.get(url);

        //Click on blinking text on top right
        driver.findElement(By.className("blinkingText")).click();

        //Get id of all tabs opened
        Set<String> tabs = driver.getWindowHandles();

        //Create iterator to get child element window id
        Iterator<String> it = tabs.iterator();
        String parentID = it.next();  //Get parent id
        String childID = it.next();   //Get child id

        //Switch to new opened tab
        driver.switchTo().window(childID);

        //Extract email from paragraph.
        //Split string into 2 parts using split usine "at " delimiter. Our email is in [1]
        //Again split element [1] using " " and we get email in first part i.e. [0]
        String emailID = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at ")[1].split(" ")[0];

        //Switch to parent id
        driver.switchTo().window(parentID);

        //Enter user name as email
        driver.findElement(By.id("username")).sendKeys(emailID);






    }
}
