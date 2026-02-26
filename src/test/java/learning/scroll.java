package learning;//JS executor
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class scroll {
    public static void main(String[] args) throws InterruptedException {
        //Initial setup
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //BEGIN SCRIPT FROM HERE---------------------------------------------------

        String url = "https://rahulshettyacademy.com/AutomationPractice/";
        driver.get(url);

        //Execute JS code in browser to learning.scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");  //Scroll down to table
        Thread.sleep(1000);  //Just a small delay to observe the learning.scroll happening
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");  //Scroll down in table by 500px until end

        //Get all values and sum it up
        List<WebElement> Values = driver.findElements(By.xpath("//div[@class='tableFixHead']//tbody//tr//td[4]"));
        int total=0;

        for(int i=0;i<Values.size();i++)
         total = total + Integer.parseInt(Values.get(i).getText());

        //Assert our total with the value shown below table in site
        WebElement Value_Displayed = driver.findElement(By.cssSelector(".totalAmount"));  //Get value displayed in webelement
        String[] Value_Displayed_Array= Value_Displayed.getText().split(" ");  //Extract the text and split it using ' '. Value 296 is at index 3
        int value = Integer.parseInt(Value_Displayed_Array[3]);     //Parse it to int from string
        Assert.assertEquals(total,value);  //Assert the obtained value with total value we calculated earlier
        System.out.println("Calculated value: "+total);
        System.out.println("Extracted value: "+value);

    }
}
