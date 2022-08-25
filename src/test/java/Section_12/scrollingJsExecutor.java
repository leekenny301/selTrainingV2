package Section_12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class scrollingJsExecutor {
    private WebDriver driver;
    private JavascriptExecutor js;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void test(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //scroll down by 500 pixels
        js.executeScript("window.scrollBy(0, 500)");
        js.executeScript("document.querySelector()");


    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
