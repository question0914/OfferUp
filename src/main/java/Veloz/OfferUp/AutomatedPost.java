package Veloz.OfferUp;

/**
 * Created by zijianli on 6/22/17.
 */

import io.selendroid.client.SelendroidDriver;
import io.selendroid.client.SelendroidKeys;
import io.selendroid.common.SelendroidCapabilities;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;


public class AutomatedPost {
    private SelendroidDriver driver = null;


    @Before
    public void setup() throws Exception{
        driver = new SelendroidDriver(new SelendroidCapabilities("com.offerup:2.10.1"));

    }

    @Test
    public void start() throws Exception{
        driver.get("and-activity://com.offerup.android.activities.SplashActivity");
        Thread.sleep(5000);
        WebElement allow_location = driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
        allow_location.click();
        Thread.sleep(5000);
        driver.findElement(By.id("post_item")).click();
        driver.findElement(By.id("loginOfferUp")).click();
        //Thread.sleep(1000);
        driver.findElement(By.id("emailaddress")).sendKeys("answer0914@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("login")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("pre_post_help_forward_button")).click();
        driver.findElement(By.id("pre_post_help_forward_button")).click();
        driver.findElement(By.id("pre_post_help_footer_text")).click();
        driver.findElement(By.id("addPhotoFromGallery")).click();
        Thread.sleep(5000);

    }


    @After
    public void teardown() {
        driver.quit();
    }
}
