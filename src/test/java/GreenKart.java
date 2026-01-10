import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GreenKart {
    public static void main(String[] args)
    {
        //Start chrome browser and maximize window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Navigate to Greenkart site
        String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
        driver.get(url);

        //Get list of all product names
        List<WebElement> products = driver.findElements(By.className("product-name"));

        for(int i=0;i<products.size();i++)
        {
            String name = products.get(i).getText();

            if(name.contains("Potato"))
            {
                driver.findElements(By.xpath("(//a[@class='increment'])")).get(i).click();
                driver.findElements(By.xpath("(//a[@class='increment'])")).get(i).click();

                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
            }
        }
    }
}
