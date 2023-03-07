package com.solvd.carina.demo.web;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.carina.demo.gui.components.task.FooterMenu;
import com.solvd.carina.demo.gui.pages.task.HomePage;
import com.solvd.carina.demo.gui.pages.task.LoginPasswordPage;
import com.solvd.carina.demo.gui.pages.task.LoginUsernamePage;
import com.solvd.carina.demo.gui.pages.task.SportsPage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertTrue;


public class WebTaskTest extends AbstractTest {


    @Test
    @MethodOwner(owner = "maratano")
    public void testIsHomePageOpened() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
    }

    @Test
    @MethodOwner(owner = "maratano")
    public void testIsLoginButtonPresent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
        assertTrue(homePage.isLoginButtonPresent(), "Login button isn't present");
    }

    @Test
    @MethodOwner(owner = "maratano")
    public void testIsFooterPresent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
        FooterMenu footerMenu = homePage.getFooterMenu();
        Assert.assertTrue(footerMenu.isUIObjectPresent(2), "Footer menu wasn't found!");
    }


    @Test()
    @MethodOwner(owner = "maratano")
    public void testFooterLinks() {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,3000)");

        FooterMenu footer = homePage.getFooterMenu();
        footer.clickTwitter();
        ArrayList<String> handlers = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handlers.get(1));
        Assert.assertEquals(getDriver().getCurrentUrl(), R.TESTDATA.get("twitter_url"));
        driver.close();
    }

    /*@Test
    public void testFillRandomDataInAccountDetails() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");

        LoginUsernamePage loginUsernamePage = homePage.clickLoginButton();
        Assert.assertTrue(loginUsernamePage.isPageOpened(), "Login page isn't opened");

        loginUsernamePage.fillUsername(R.TESTDATA.get("user_1_username"));
        RegisterPage registerPage = loginUsernamePage.clickLoginUsernameButton();
        Assert.assertTrue(registerPage.isPageOpened(), "Register page isn't opened");

        CreateAccountPage createAccountPage = registerPage.clickRegisterButton();
        Assert.assertTrue(createAccountPage.isPageOpened(), "Create Account page isn't opened");

        createAccountPage.fillAccountDetails(R.TESTDATA.get("user_1_fullname"), R.TESTDATA.get("user_1_email"), R.TESTDATA.get("user_1_password"), R.TESTDATA.get("user_1_birth"));

    }*/

    @Test
    @MethodOwner(owner = "maratano")
    public void testWrongPasswordInserted() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");

        LoginUsernamePage loginUsernamePage = homePage.clickLoginButton();
        Assert.assertTrue(loginUsernamePage.isPageOpened(), "Login username page isn't opened");
        loginUsernamePage.fillUsername(R.TESTDATA.get("user_2_username"));

        LoginPasswordPage loginPasswordPage = loginUsernamePage.clickLoginUsernameButton();
        Assert.assertTrue(loginPasswordPage.isPageOpened(), "Login password page isn't opened");
        loginPasswordPage.fillPassword(R.TESTDATA.get("user_2_password"));
        loginPasswordPage.clickLoginButton();

        Assert.assertTrue(loginPasswordPage.isWrongPassLabelPresent(), "Wrong password");
    }

    @Test
    @MethodOwner(owner = "maratano")
    public void testGoToSportsPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
        SportsPage sportsPage = homePage.clickSportsLabel();
        Assert.assertTrue(sportsPage.isPageOpened(), "Sports page isn't opened");
    }


}
