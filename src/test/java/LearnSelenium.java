import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LearnSelenium {
    public static void main (String args[])
    {

        //SETUP PARAMETERS AND VARIABLES HERE-----------------------------------------------

        String url = "https://www.spicejet.com/";
        WebDriver driver = new ChromeDriver();  //Launch chrome driver
        driver.manage().window().maximize();    //Maximize window


        //BEGIN SCRIPTING FROM HERE-----------------------------------------------

        //Navigate to url
        driver.get(url);

        //Check if return date disabled or not
        String style = driver.findElement(By.xpath("(//div[@class='css-76zvg2 css-bfa6kz r-1862ga2 r-1gkfh8e'])[2]")).getAttribute("style");
        if(style.contains("opacity"))
        {
            System.out.println("Return date enabled");
            Assert.assertTrue(false);
        }
        else
        {
            System.out.println("Return date disabled");
            Assert.assertTrue(true);
        }

        //Click on round trip
        //driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-117bsoe r-1p4rafz r-1otgn73'][2]")).click();
        driver.findElement(By.xpath("//*[text()='round trip']")).click();

        //Select City 1 - Goa
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']")).click();  //Click on drop down menu
        driver.findElement(By.xpath(("//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-1wtj0ep r-b5h31w r-rnv2vh r-5njf8e r-1otgn73'][13]"))).click();  //Select Goa

        //Select city 2 - Phuket
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1loqt21 r-p1pxzi r-qi0n3 r-1otgn73']")).click();   //Select International
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-1wtj0ep r-b5h31w r-rnv2vh r-5njf8e r-1otgn73'][6]")).click();  //Select Phuket

        //Select Dept. date - Today
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-16ru68a r-y47klf r-1loqt21 r-17b3b9k r-1otgn73 r-1aockid']")).click();

        //Select Return date -
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-16ru68a r-y47klf r-1loqt21 r-17b3b9k r-1otgn73 r-1aockid']")).click();

        //Select No. of passengers -
        driver.findElement(By.xpath("//*[text()='Passengers']")).click();  //Click on passengers dropdown

        driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-y47klf r-1loqt21 r-eu3ka r-1777fci r-1otgn73 r-eafdt9 r-1i6wzkk r-lrvibr r-1aockid'])[1]")).click();  //Add 1 more adult

        driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-y47klf r-1loqt21 r-eu3ka r-1777fci r-1otgn73 r-eafdt9 r-1i6wzkk r-lrvibr r-1aockid'])[2]")).click();  //Add 1 child

        //Change currency to USD-
        driver.findElement(By.xpath("//*[text()='Currency']")).click();  //Click on currency dropdown
        driver.findElement(By.xpath("//*[text()='USD']")).click();  //Click on USD

        //Click on Govt employee radio button-
        driver.findElement(By.xpath("(//div[text()='Govt. Employee'])[2]")).click();

        //Click on Search Flight button-
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73']")).click();



    }
}
