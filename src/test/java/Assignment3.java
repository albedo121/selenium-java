import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class Assignment3 {
    public static void main(String[] args) {

        //DO INITIAL SETUP HERE----------------------------------------------------

        //Setting up chrome options and launching browser
        ChromeOptions options = new ChromeOptions();
        HashMap<String,Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_leak_detection", false);   //We are disabling unnecessary chrome password alerts
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();        //Maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //Implicit wait of 10s
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //Explicit wait of 10s
        Wait<WebDriver> fwait = new FluentWait<>(driver)   //Fluent wait of 10s with polling of 2s
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        //BEGIN SCRIPT FROM HERE---------------------------------------------------
        //Define global variables here
        String url = "https://rahulshettyacademy.com/loginpagePractise/";
        String userName = "rahulshettyacademy";
        String password = "learning";

        driver.get(url);  //Navigate to site

        loginPage(driver, userName, password, wait);  //Login in the page

        productPage(driver, wait);

    }

    public static void loginPage(WebDriver driver, String userName, String password, WebDriverWait wait) {
        //Login page
        driver.findElement(By.id("username")).sendKeys(userName);  //Enter username
        driver.findElement(By.id("password")).sendKeys(password);  //Enter password
        driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();  //Click on user radio button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn"))).click();

        Select dropdown = new Select(driver.findElement(By.cssSelector("select[class='form-control']")));   //Select dropdown
        dropdown.selectByIndex(2);   //Select 3rd item - Consultant

        driver.findElement(By.id("terms")).click();  //Click on I agree check box
        driver.findElement(By.id("signInBtn")).click();  //Click on sign in button
    }

    public static void  productPage(WebDriver driver, WebDriverWait wait){

        List<WebElement> products = driver.findElements(By.xpath("//button[text()='Add ']"));   //Get list of all product's add to cart button
        for (int i=0;i<products.size();i++)
            products.get(i).click();    //Click on each button one by one

        driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).click(); //Click on checkout button

    }

}

