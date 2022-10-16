package section_13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HTTPS_certifications {

    ChromeOptions options;
    WebDriver driver;

    public void chromeSetup(ChromeOptions options){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @BeforeTest
    public void setup(){
        options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        chromeSetup(options);
    }

    @Test
    public void test(){
        driver.get("https://expired.badssl.com/");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
