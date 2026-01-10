import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {
    public static void main(String[] args)
    {
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       String url = "https://rahulshettyacademy.com/angularpractice/";

       //Navigate to page
       driver.get(url);

       //Enter form details
       driver.findElement(By.name("name")).sendKeys("Jane Doe");   //Enter name
       driver.findElement(By.name("email")).sendKeys("johndoe@test.com");  //Enter email
       driver.findElement(By.id("exampleInputPassword1")).sendKeys("Testpassword123");
       driver.findElement(By.id("exampleCheck1")).click();  //Click on checkbox

        //Select Female gender
        Select dropdown = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
        dropdown.selectByVisibleText("Female");

        //Select student
        driver.findElement(By.id("inlineRadio1")).click();

        //Enter bith date
        driver.findElement(By.name("bday")).sendKeys(("01-01-1990"));

        //Click on submit
        driver.findElement(By.cssSelector(".btn.btn-success")).click();

        //Get status message
        System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());

    }
}
