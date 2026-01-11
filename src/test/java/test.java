import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
    public static void main(String[] args)
    {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://www.cloudflare.com/";

        driver.get(url);
    }
}
