//Go to mentioned url. From table - "Web Table Example" display no of rows, columns and print the 2nd row content

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Assignment7 {
    public static void main(String[] args) {
        //Initial Setup
        WebDriver driver = new ChromeDriver();  //Invoke chrome browser
        driver.manage().window().maximize();  //Maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Implicit wait of 10s

        //BEGIN SCRIPT FROM HERE---------------------------------------------------
        String url = "https://rahulshettyacademy.com/AutomationPractice/";
        driver.get(url);

        //Get no of rows and columns of table
        List<WebElement> Table_Rows = driver.findElements(By.xpath("//table[@name='courses']//tr"));
        List<WebElement> Table_Columns = driver.findElements(By.xpath("//table[@name='courses']//tr//th"));
        WebElement Second_Row = driver.findElement(By.xpath("//table[@name='courses']//tr[3]"));

        //Print the values
        System.out.println("No. of rows: " +Table_Rows.size());
        System.out.println("No. of columns: " +Table_Columns.size());
        System.out.println("2nd Row: " +Second_Row.getText());
    }
}
