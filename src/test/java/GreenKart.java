import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreenKart {
    public static void main(String[] args) {
        //Start chrome browser and maximize window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   //Implicit wait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));  //Explicit wait

        //Navigate to Greenkart site
        String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
        driver.get(url);

        //Create an array of list of products to be added
        String[] Add_Products = {"Potato", "Tomato", "Strawberry", "Corn", "Walnuts"};

        //Add products to cart
        addItems(driver, Add_Products);

        //Click on cart button and then checkout button
        driver.findElement(By.cssSelector("a[class='cart-icon']")).click();
        driver.findElement(By.xpath("//button[text()=\"PROCEED TO CHECKOUT\"]")).click();


        //Enter promocode and click apply using explicit wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class='promoCode']"))).sendKeys("rahulshettyacademy");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='promoBtn']"))).click();

        //Retrieve code applied text
        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='promoInfo']"))).getText());

    }

    public static void addItems(WebDriver driver, String[] Add_Products){

        //Convert array to list to consume less memory
        List Add_Products_List = Arrays.asList(Add_Products);

        //Get list of all product names
        List<WebElement> products = driver.findElements(By.className("product-name"));

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
                    break;

            }
        }
    }
}


