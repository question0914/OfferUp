package Veloz.OfferUp;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by zijianli on 6/29/17.
 */
public class AutomatedTest {
    public AndroidDriver driver;

    @Before
    public void setup() throws Exception {
        File appDir = new File("/Users/zijianli/Downloads");
        File app = new File(appDir, "com.offerup_2017-06-15.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("device","Android");

        //mandatory capabilities
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","8.0.0");

        capabilities.setCapability("appPackage", "com.offerup");
        capabilities.setCapability("appActivity", "com.offerup.android.activities.SplashActivity");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        driver =  new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }
    @Test
    public void start() throws Exception{
        driver.context("NATIVE_APP");
        Thread.sleep(3000);
        WebElement allow_location = driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
        allow_location.click();

        WebDriverWait pause = new WebDriverWait(driver, 5);
        WebElement post = pause.until(ExpectedConditions.elementToBeClickable(By.id("post_item")));
        post.click();

        driver.findElement(By.id("loginOfferUp")).click();
        driver.findElement(By.id("emailaddress")).sendKeys("answer0914@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);
        /*
        driver.findElement(By.id("pre_post_help_forward_button")).click();
        driver.findElement(By.id("pre_post_help_forward_button")).click();
        driver.findElement(By.id("pre_post_help_footer_text")).click();*/
        Thread.sleep(2000);

        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.className("android.widget.CheckedTextView"));
        System.out.println(list.size());

        System.out.println(list.size());
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i).getText());
        }

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("addPhotoFromGallery")));
        element.click();
        Thread.sleep(5000);

    }

    @After
    public void teardown() {
        driver.quit();
    }

}
