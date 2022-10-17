package Section_12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TableGrids {
    WebDriver driver;
    int sum;
    String totalAmountText;
    int totalAmount;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void test(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> amount = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

        for (int i = 0; i<amount.size(); i++){
            sum += Integer.parseInt(amount.get(i).getText());
        }

        totalAmountText = driver.findElement(By.cssSelector(".totalAmount")).getText();
        totalAmount = Integer.parseInt(totalAmountText.split(": ")[1]);

        Assert.assertEquals(totalAmount, sum);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
