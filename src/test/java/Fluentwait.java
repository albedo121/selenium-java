import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.time.Duration;

public class Fluentwait {
    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(12))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        String url = "https://the-internet.herokuapp.com/dynamic_loading/1";

        driver.get(url);

        driver.findElement(By.xpath("//button[text()='Start']")).click();
        WebElement element = wait.until(d -> {
            WebElement h4 = driver.findElement(By.id("finish"));
            if(h4.isDisplayed())
                return h4;
            else
                return null;
        });
        System.out.println(element.getText());


    }
}
