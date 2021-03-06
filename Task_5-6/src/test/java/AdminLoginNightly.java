import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class AdminLoginNightly {

    private WebDriver driver;

    @Before
    public void setUp() {
        FirefoxOptions options = new FirefoxOptions()
                .setBinary("/opt/firefoxNightly/firefox")
                .setProfile(new FirefoxProfile());
        driver = new FirefoxDriver(options);
        System.out.println(((HasCapabilities) driver).getCapabilities()); //вывести настройки веб-драйвера

        driver.navigate().to("http:/localhost/litecart/admin");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void adminLogin() {
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.cssSelector(".btn")).click();
        driver.findElement(By.cssSelector(".fa-sign-out")).click();
    }
}
