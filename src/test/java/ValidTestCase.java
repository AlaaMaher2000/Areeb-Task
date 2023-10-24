import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class ValidTestCase {

    ChromeDriver driver;
    WebElement login;

    @BeforeMethod
    public void setupMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        login = driver.findElement(By.name("login-button"));
    }
    @Test
    public void testValidLogin1() {
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        login.click();
    }

    @Test()
    public void testValidLogin2() {
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("problem_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        login.click();
    }

    @Test()
    public void testValidLogin3() {
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("performance_glitch_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        login.click();
    }

    @Test()
    public void testValidLogin4() {
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("error_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        login.click();
    }

    @Test()
    public void testValidLogin5() {
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("visual_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        login.click();
    }

    @AfterMethod
    public void assertAfterTest() {
        String actual = driver.getCurrentUrl();
        String expected = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actual, expected);
        driver.quit();
    }

}

