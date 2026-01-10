import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertBox {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://rahulshettyacademy.com/AutomationPractice/";

        driver.get(url);

        //Enter name in input box
        driver.findElement(By.id("name")).sendKeys("John Doe");

        //Press Alert button
        driver.findElement(By.id("alertbtn")).click();

        //Switch to alert window, get text and press ok
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //Press Confirm button
        driver.findElement(By.id("confirmbtn")).click();

        //Switch to 2nd alert window, get text and press cancel
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
    }
}
