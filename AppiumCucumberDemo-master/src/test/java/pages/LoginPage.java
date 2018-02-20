package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class LoginPage extends BasePage {

    By pullMenu = By.xpath("//*[@content-desc = 'Navigate up']");
    By loginButton = By.id(app_package_name+"tv_login");
    By continue_button = By.id(app_package_name+"btn_ldap_login_continue");
    By agree=By.id(app_package_name+"btn_tnc_ok");
    By userId = By.id(app_package_name + "et_ldap_login_username");
    By password = By.id(app_package_name + "et_ldap_login_password");
    By latest = By.xpath("//android.widget.TextView[@text='LATEST']");
    //By layout=By.id(app_package_name +"layout_item");

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }


    public void Login(String username, String password) {
        waitForVisibilityOf(userId);
        driver.findElement(userId).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(continue_button).click();
    }


    public void waitForLoginScreen() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("com.buuuk.st:id/btn_tnc_ok")).click();
        leftRightSwipe(1000);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.findElement(By.id("com.buuuk.st:id/tv_skip_intro")).click();
        waitForVisibilityOf(pullMenu);
        driver.findElement(pullMenu).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        waitForVisibilityOf(loginButton);
        driver.findElement(loginButton).click();
        waitForVisibilityOf(userId);
    }

    public void navigateToLatest() {

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(latest).click();

    }

    public void verifyLogin(String email) {

        String source;
        source = driver.getPageSource();
        assertTrue(source.contains(email));

    }

    public void openFirstArticleandAssert() {

        List<WebElement> list=new ArrayList<WebElement>();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        list = driver.findElementsById("com.buuuk.st:id/layout_item");
        list.get(0).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(latest).click();
        String text = driver.findElement(latest).getText();
        assertTrue(text.contains("LATEST"));


    }
}
