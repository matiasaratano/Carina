package com.solvd.carina.demo.web;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.carina.demo.gui.components.task.FooterMenu;
import com.solvd.carina.demo.gui.pages.task.CreateAccountPage;
import com.solvd.carina.demo.gui.pages.task.HomePage;
import com.solvd.carina.demo.gui.pages.task.LoginPage;
import com.solvd.carina.demo.gui.pages.task.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

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
    public void footerTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        FooterMenu footerMenu = homePage.getFooterMenu();
        Assert.assertTrue(footerMenu.isUIObjectPresent(2), "Footer menu wasn't found!");
    }
}
