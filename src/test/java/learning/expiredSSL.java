package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Arrays;

public class expiredSSL {
    public static void main(String[] args) {
        //Initial Setup
        ChromeOptions options = new ChromeOptions();  //Create new object options to set options

        options.setAcceptInsecureCerts(true);  //Set flag true to accept expired ssl certificate

        Proxy proxy = new Proxy();  //Set proxy value
        proxy.setHttpProxy("1.1.1.1");  //Just using a random proxy ip
        options.setCapability("proxy",proxy);

        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));  //Disable any popups like 'know ur location popup'

        WebDriver driver = new ChromeDriver(options);  //Invoke chrome browser

        driver.manage().window().maximize();  //Maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Implicit wait of 10s

        //BEGIN SCRIPT FROM HERE---------------------------------------------------
        String url = "https://expired.badssl.com/";
        driver.get(url);

        //Get main text
        System.out.println(driver.findElement(By.id("content")).getText());
    }
}
