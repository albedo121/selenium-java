package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragDrop {
    public static void main(String[] args) {

        //Initial Setup
        WebDriver driver = new ChromeDriver();  //Open chrome driver
        driver.manage().window().maximize();  //Maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //Implicit wait of 10s

        //SCRIPT BEGINS FROM HERE--------------------------------------------------------
        String url = "https://jqueryui.com/droppable/";
        driver.get(url);

        WebElement iframe = driver.findElement(By.cssSelector("iframe[class='demo-frame']"));  //Locate the iframe
        //driver.switchTo().frame(0);  //Switch to iframe using index
        driver.switchTo().frame(iframe);  //Switch to the iframe

        WebElement source = driver.findElement(By.cssSelector("#draggable"));   //Find box top drag
        WebElement destination = driver.findElement(By.cssSelector("#droppable"));  //Find box in which we drop

        Actions action = new Actions(driver);   //Create actions class
        action.dragAndDrop(source,destination).build().perform();  //Drag and drop the box

        driver.switchTo().defaultContent();  //Get out of iframe

        System.out.println(driver.findElement(By.cssSelector(".entry-title")).getText());  //Get h3 text to verify we are out of iframe

    }
}
