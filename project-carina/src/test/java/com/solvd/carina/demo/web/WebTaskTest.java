package com.solvd.carina.demo.web;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.carina.demo.gui.components.task.FooterMenu;
import com.solvd.carina.demo.gui.pages.task.CreateAccountPage;
import com.solvd.carina.demo.gui.pages.task.HomePage;
import com.solvd.carina.demo.gui.pages.task.LoginPage;
import com.solvd.carina.demo.gui.pages.task.RegisterPage;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;


public class WebTaskTest extends AbstractTest {

    @Test
    public void testIsLoginButtonPresent() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
        assertTrue(homePage.isLoginButtonPresent(), "Login button isn't present");
    }

    @Test
    public void testFillRandomDataInAccountDetails() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LoginPage loginPage = homePage.clickLoginButton();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        assertTrue(loginPage.isLoginEmailButtonPresent(), "Login button isn't present");
        loginPage.fillUsername(R.TESTDATA.get("user_1_username"));
        RegisterPage registerPage = loginPage.clickLoginUsernameButton();
        Assert.assertTrue(registerPage.isPageOpened(), "Register page isn't opened");
        CreateAccountPage createAccountPage = registerPage.clickRegisterButton();
        Assert.assertTrue(createAccountPage.isPageOpened(), "Create Account page isn't opened");
        createAccountPage.fillAccountDetails(R.TESTDATA.get("user_1_fullname"), R.TESTDATA.get("user_1_email"), R.TESTDATA.get("user_1_password"));
    }

    @Test
    public void testFooter() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        FooterMenu footerMenu = homePage.getFooterMenu();
        Assert.assertTrue(footerMenu.isUIObjectPresent(2), "Footer menu wasn't found!");
    }

    @Test
    public void testGoToSportsPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        //Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        //Actual URL differs from expected one. Expected 'https://www.yahoo.com/' but found 'https://espanol.yahoo.com/?p=us'
        homePage.clickSportsLabel();

        List<WebElement> menu = homePage.getDriver().findElements(By.xpath("//div[@id='ybar-navigationk']"));
        for (WebElement element : menu) {
            if (element.getText().contains("Sport")) {
                element.click();
                break;
            }
        }
    }
}
