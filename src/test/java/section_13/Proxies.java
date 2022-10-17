package section_13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

public class Proxies {
    ChromeOptions options;
    WebDriver driver;

    Proxy proxy;

    public void proxySetup(){
        proxy = new Proxy();
        proxy.setHttpProxy("ipaddress:4444");
        options.setCapability("proxy", proxy);
    }

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
        proxySetup();
    }
}
