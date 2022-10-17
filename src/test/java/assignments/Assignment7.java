package assignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

/*
3 scenarios for Web Table Example:
i. Print number of rows (including header)
ii. Print number of columns
iii. Print 2nd row of data
 */

public class Assignment7 {

    WebDriver driver;
    @FindBy(css = "table[name='courses'] tr")
    List<WebElement> rows;
    @FindBy(css = "table[name='courses'] tr th")
    List<WebElement> columns;
    int rowsSize;
    int columnsSize;
    List<WebElement> secondRow;

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
        PageFactory.initElements(driver, this);

        //i. Print number of rows (including header)
        rowsSize = rows.size();
        System.out.println(rowsSize);

        //ii. Print number of columns
        columnsSize = columns.size();
        System.out.println(columnsSize);

        //iii. Print 2nd row of data
        secondRow = rows.get(2).findElements(By.tagName("td"));
        System.out.println("Instructor: " + secondRow.get(0).getText());
        System.out.println("Course: " + secondRow.get(1).getText());
        System.out.println("Price: " + secondRow.get(2).getText());
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
