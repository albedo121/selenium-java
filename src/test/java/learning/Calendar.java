package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Calendar {
    public static void main(String[] args) {
        //Initial Setup
        WebDriver driver = new ChromeDriver();  //Invoke chrome browser
        driver.manage().window().maximize();  //Maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Implicit wait of 10s

        //BEGIN SCRIPT FROM HERE---------------------------------------------------
        String url = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
        String month = "9", day = "1", year = "2026";
        String[] InputDate = {month,day, year};
        driver.get(url);

        //Click on calendar and select the date
        driver.findElement(By.cssSelector("button[class='react-date-picker__calendar-button react-date-picker__button']")).click();  //open calendar
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();  //click 2 times to get to year

        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();  //select year 2026
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();  //Select month september
        driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();  //Select 1st date

        //Get date value for assertion
        List<WebElement> RetrievedDate = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for(int i=0;i<RetrievedDate.size();i++)
            Assert.assertEquals(RetrievedDate.get(i).getAttribute("value") , InputDate[i]);

        driver.quit();

    }
}
