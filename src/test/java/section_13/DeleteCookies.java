package section_13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteCookies {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();

        //deletes all cookies
        driver.manage().deleteAllCookies();

        //deletes one cookie following that name
        driver.manage().deleteCookieNamed("asdasd");
    }

    @Test
    public void test(){
        driver.get("http://google.com");
    }
}
