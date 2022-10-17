package section_13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class AutomateBrokenLink {

    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws IOException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Get all urls tied up to the links using Selenium
        // Java methods to call the URL's and gets you the status code
        // if status code is > 400, then that url is not working

        linksIterator();
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    public void linksIterator() throws IOException {
        List<WebElement> links = driver.findElements(By.cssSelector("li[class*='gf-li'] a"));
        for (WebElement link: links) {
            String url = link.getAttribute("href");
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int respCode = connection.getResponseCode();
            System.out.println(respCode);
            softAssert.assertTrue(respCode < 400, "The link with text (" + link.getText() + ") is broken with code: " + respCode);
        }
        softAssert.assertAll();
    }

}
