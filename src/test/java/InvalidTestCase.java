import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class InvalidTestCase {

    ChromeDriver driver;
    WebElement login;
    SoftAssert softAssert = new SoftAssert();


    @BeforeMethod
    public void testOpenBrowser() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://www.saucedemo.com/");
        login = driver.findElement(By.name("login-button"));
    }

    @Test()
    public void testInValidLoginUsernameValidPassword() {
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("performanc_glitch_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        login.click();
    }

    @Test()
    public void testInValidLoginPasswordValidUsername() {
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("performance_glitch_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secre_sauce");
        login.click();
    }

    @Test()
    public void testInValidLoginPasswordInvalidUsername() {
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("perforance_glitch_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secre_sauce");
        login.click();

    }


    @AfterMethod
    public void assertAfterTest() {
        String actualElement = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        String expectedElement = "Epic sadface: Username and password do not match any user in this service";
        softAssert.assertEquals(actualElement, expectedElement);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/";
        softAssert.assertEquals(actualUrl, expectedUrl);
        softAssert.assertAll();
        driver.quit();
    }

}

