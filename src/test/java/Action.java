//ACTION CLASSES
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Action {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //SCRIPT BEGINS FROM HERE
        String url = "https://www.amazon.in/";
        Actions action = new Actions(driver);

        driver.get(url);  //Navigate to site

        //WebElement NavBar = driver.findElement(By.cssSelector("span[class='nav-line-2 ']"));
        //action.moveToElement(NavBar).build().perform();  //Hover to username in navbar

        WebElement SearchBox = driver.findElement(By.id("twotabsearchtextbox"));
        //action.moveToElement(SearchBox).click().keyDown(Keys.LEFT_SHIFT).sendKeys("tp link archer ax10");
        action.click(SearchBox).keyDown(Keys.LEFT_SHIFT).sendKeys("tp link archer ax10");



    }

}


