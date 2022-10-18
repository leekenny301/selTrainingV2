package section_14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class FilterWebTable {
    WebDriver driver;

    @FindBy(id = "search-field")
    WebElement searchFieldBox;

    @FindBy(xpath = "//tr/td[1]")
    List<WebElement> vegFruitFirstColumn;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    @Test
    public void test(){
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        searchFieldBox.sendKeys("Rice");
        List<String> vegFruitColumnList = vegFruitFirstColumn.stream().map(WebElement::getText).filter(s -> s.contains("Rice")).toList();
        Assert.assertEquals(vegFruitFirstColumn.size(), vegFruitColumnList.size());
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
