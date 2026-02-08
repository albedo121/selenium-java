import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class LoginPage {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://rahulshettyacademy.com/loginpagePractise/";
        driver.get(url);

        driver.findElement(By.cssSelector("a[class='blinkingText']")).click();

        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows);
    }
}
