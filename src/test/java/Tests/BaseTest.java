package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.OpenPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    OpenPage openPage;


    @BeforeMethod
    public void setup(){
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,30);
        openPage = new OpenPage(driver);
        String url = "https://www.nagwa.com/en";
        driver.navigate().to(url);
        wait.until(ExpectedConditions.titleContains("Nagwa"));

    }

    @AfterMethod
    public void quitWebDriver(){
        driver.quit();
   }
}
