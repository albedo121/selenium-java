//In suggestion class example input box input kwd 'ind' and select India from suggestions. Verify that india is present in text bpx

package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Assignment8 {
    public static void main(String[] args) throws InterruptedException {
        //Initial Setup
        WebDriver driver = new ChromeDriver();  //Invoke chrome browser
        driver.manage().window().maximize();  //Maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Implicit wait of 10s

        //BEGIN SCRIPT FROM HERE---------------------------------------------------
        String url = "https://rahulshettyacademy.com/AutomationPractice/";
        driver.get(url);

        //Find the 'Suggestion class example' text box and send keys ind
        driver.findElement(By.id("autocomplete")).sendKeys("ind");

        //Wait for suggestion menu to load
        driver.findElement(By.cssSelector(".ui-menu-item-wrapper"));

        //Press down arrow 2 times to select India
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

        //Get text from text box
        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));

    }
}
