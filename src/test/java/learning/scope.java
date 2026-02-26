package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class scope {
    public static void main(String[] args) throws InterruptedException {
        //Initial setup
        WebDriver driver = new ChromeDriver();  //Invoke chrome driver
        driver.manage().window().maximize();  //maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Implicit wait of 10s

        //SCRIPT BEGINS FROM HERE-------------------------------------------------
        String url = "https://rahulshettyacademy.com/AutomationPractice/";
        driver.get(url);

        WebElement FooterSection= driver.findElement(By.id("gf-BIG"));  //Create footer learning.scope
        System.out.println(FooterSection.findElements(By.tagName("a")).size());  //Find total links in footer

        WebElement column1 = FooterSection.findElement(By.xpath("//table/tbody//tr//td[1]/ul"));  //Find column1
        System.out.println(column1.findElements(By.tagName("a")).size());

        OpenLinks(driver, column1);

    }

    public static void OpenLinks(WebDriver driver, WebElement column1) throws InterruptedException {

        int size = column1.findElements(By.tagName("a")).size();  //Get no. of links in column 1
        String NewTabKeys = Keys.chord(Keys.CONTROL, Keys.ENTER);  //Create keyboard input for ctrl + enter button

        for(int i=1;i<size;i++)
            column1.findElements(By.tagName("a")).get(i).sendKeys(NewTabKeys);  //click on all links in column1

        Thread.sleep(5000L);

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> IT = handles.iterator();

        while(IT.hasNext())
        {
            driver.switchTo().window(IT.next());
            System.out.println(driver.getTitle());
        }




    }
}
