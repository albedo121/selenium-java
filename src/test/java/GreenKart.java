import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreenKart {
    public static void main(String[] args) throws InterruptedException {
        //Start chrome browser and maximize window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Navigate to Greenkart site
        String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
        driver.get(url);

        //Get list of all product names
        List<WebElement> products = driver.findElements(By.className("product-name"));

        //Create an array of list of products to be added
        String[] Add_Products = {"Potato", "Tomato", "Strawberry", "Corn", "Walnuts"};
        List Add_Products_List = Arrays.asList(Add_Products);   //Convert array to list to consume less memory

        int x=0;  //We use this flag to break loop when all products are added

        for (int i = 0; i < products.size(); i++)
        {
            String[] name = products.get(i).getText().split("-");

            if (Add_Products_List.contains(name[0].trim()))
            {
                driver.findElements(By.xpath("(//a[@class='increment'])")).get(i).click();    //Add one more quantity
                driver.findElements(By.xpath("(//a[@class='increment'])")).get(i).click();    //Add one more quantity
                driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();   //Click on add to cart

                x++;

                if(x==Add_Products.length)
                {
                    System.out.println("Loop broken");
                    break;
                }
            }
        }


    }
}
