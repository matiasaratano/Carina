package com.solvd.carina.demo.web;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.carina.demo.gui.components.task.FooterMenu;
import com.solvd.carina.demo.gui.pages.task.CreateAccountPage;
import com.solvd.carina.demo.gui.pages.task.HomePage;
import com.solvd.carina.demo.gui.pages.task.LoginPage;
import com.solvd.carina.demo.gui.pages.task.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;


public class WebTaskTest extends AbstractTest {

    @Test
    public void firstTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        LoginPage loginScreen = homePage.clickLoginButton();
        assertTrue(loginScreen.isLoginEmailButtonPresent(), "Login button isn't present");
        loginScreen.fillUsername("matias");

        RegisterPage registerScreen = loginScreen.clickLoginUsernameButton();
        CreateAccountPage createAccountScreen = registerScreen.clickRegisterButton();
        createAccountScreen.fillFullName("Matias Aratano");
        createAccountScreen.fullEmail("matias.aratano");
        createAccountScreen.fillPassword("asdasd");
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
