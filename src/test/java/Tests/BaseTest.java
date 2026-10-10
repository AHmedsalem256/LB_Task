package Tests;

import Data.LoadProperties;
import Pages.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.Properties;


public class BaseTest {


    //Load Data
    Properties prop;
    //Define WebDriver
    public static WebDriver driver ;
    //DefineWebWait Element
    WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(100));


    //CreateObjectFromLandingPage
    LandingPage LP = new LandingPage(driver);


    @BeforeTest
    public void Setup(){
        prop = LoadProperties.LoadTheData("src/test/resources/Env.properties");
        System.setProperty("webdriver.edge.driver","Drivers/msedgedriver.exe");
        System.setProperty("webdriver.edge.driver.forceDownload", "true");

        driver  = new EdgeDriver();
        driver.manage().window().maximize();
        String url = prop.getProperty("BaseUrl");
        driver.get(url);
    }

    @AfterTest
    public void EndTest(){
       // driver.close();
    }


}
