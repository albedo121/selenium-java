import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Assignment6 {
    public static void main(String[] args) {
        //Initial Setup
        WebDriver driver = new ChromeDriver();  //Invoke chrome browser
        driver.manage().window().maximize();  //Maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Implicit wait of 10s

        //BEGIN SCRIPT FROM HERE---------------------------------------------------
        String url = "https://rahulshettyacademy.com/AutomationPractice/";
        driver.get(url);

        //Find option 3, click on it and get the text
        WebElement option3 = driver.findElement(By.cssSelector("label[for='honda']"));
        String text = option3.getText();
        driver.findElement(By.cssSelector("input[value='option3']")).click();

        //Click option3 in dropdown
        WebElement dropdown_element = driver.findElement(By.id("dropdown-class-example"));
        Select dropdown = new Select(dropdown_element);
        dropdown.selectByVisibleText(text);

        //Find 'Switch To Alert Example' input box, enter our text and press alert button
        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.id("alertbtn")).click();

        //From alert window get the text displayed
        String AlertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        if(AlertText.contains(text))

            System.out.println("Our selected text "+ text + " is present in alert box");

        else
            System.out.println("Our selected text "+ text + " is not present in alert box");
    }
}
