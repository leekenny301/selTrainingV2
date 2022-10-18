package section_14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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

public class WebTableSortingPagination {
    // Scenario 1:
    // click on column
    // capture all webelements into list
    // capture text of all webelements into new list
    // sort on the original list of step 3 -> sorted list
    // compare original list vs sorted list

    //Scenario 2:
    //Scan the name column with getText, if get Rice, return price of it
    WebDriver driver;

    List<String> price;

    @FindBy(xpath = "//span[.='Veg/fruit name']") WebElement vegFruitColumn;
    @FindBy(xpath = "//tr/td[1]") List<WebElement> vegFruitNameWebElements;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    @Test
    public void test() {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        vegFruitColumn.click();
        List<String> vegFruitNameList = vegFruitNameWebElements.stream().map(WebElement::getText).toList();
        List<String> vegFruitNameListSorted = vegFruitNameList.stream().sorted().toList();
        Assert.assertEquals(vegFruitNameListSorted, vegFruitNameList);

        System.out.println("---------Separator---------\n");

        do {
            price = vegFruitNameWebElements.stream().filter(s -> s.getText().contains("Rice"))
                    .map(WebTableSortingPagination::getPriceVegFruit).toList();
            if (price.size() == 0) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        } while (price.size() == 0);
        price.forEach(System.out::println);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    private static String getPriceVegFruit(WebElement s){
        return s.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}
