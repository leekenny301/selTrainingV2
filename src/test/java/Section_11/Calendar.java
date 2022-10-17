package Section_11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Objects;

public class Calendar {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.path2usa.com/travel-companion/");

        //August 26
        //Grab common attribute, store them in list and then iterate until you get what you want
        driver.findElement(By.id("form-field-travel_comp_date")).click();
        List<WebElement> dates = driver.findElements(By.className("flatpickr-day"));
        int count = dates.size();

        do {
            driver.findElement(By.cssSelector(".flatpickr-next-month")).click();
        }while(!Objects.equals(driver.findElement(By.cssSelector(".cur-month")).getText(), "September"));

        for (int i = 0; i < count; i++){
            String text = driver.findElements(By.className(".flatpickr-day")).get(i).getText();
            if (text.equalsIgnoreCase("26")){
                driver.findElements(By.className(".flatpickr-day")).get(i).click();
                break;
            }
        }





    }
}
