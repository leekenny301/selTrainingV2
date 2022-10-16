package assignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class assignment8 {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(css = "#autocomplete")
    WebElement autocompleteBox;
    @FindBy(css = "#ui-id-1")
    WebElement autoSuggestionsList;
    @FindBy(css = "#ui-id-1 li")
    List<WebElement> autoSuggestionsItems;


    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void test(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        PageFactory.initElements(driver, this);

        autocompleteBox.sendKeys("mal");
        wait.until(ExpectedConditions.visibilityOf(autoSuggestionsList));

        for (WebElement ignored : autoSuggestionsItems) {
            autocompleteBox.sendKeys(Keys.DOWN);
            if (Objects.equals(autocompleteBox.getAttribute("value"), "Malaysia")) {
                break;
            }
        }

        Assert.assertEquals(autocompleteBox.getAttribute("value"), "Malaysia");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
