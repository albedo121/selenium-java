package learning;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Arrays;

public class screenshot {
    public static void main(String[] args) throws IOException {
        //Initial Setup
        ChromeOptions options = new ChromeOptions();  //Create new object options to set options
        options.setAcceptInsecureCerts(true);  //Set flag true to accept expired ssl certificate

        WebDriver driver = new ChromeDriver(options);  //Invoke chrome browser
        driver.manage().window().maximize();  //Maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Implicit wait of 10s

        //BEGIN SCRIPT FROM HERE---------------------------------------------------
        String url = "https://expired.badssl.com/";
        driver.get(url);

       File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(src.toPath(), Path.of("E:\\Programming and Tutorials\\Automation\\Java\\selenium-java\\src\\test\\java\\resources\\screenshot.png"));
    }
}
