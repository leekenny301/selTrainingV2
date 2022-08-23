package assignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class assignment6 {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test(){
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("checkBoxOption2")).click();
        String option2Text = driver.findElement(By.cssSelector("label[for='benz']")).getText().strip();

        Select drpDown = new Select(driver.findElement(By.id("dropdown-class-example")));
        drpDown.selectByVisibleText(option2Text);

        driver.findElement(By.id("name")).sendKeys(option2Text);
        driver.findElement(By.id("alertbtn")).click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertTrue(alertText.contains(option2Text));
        alert.accept();
    }
}
