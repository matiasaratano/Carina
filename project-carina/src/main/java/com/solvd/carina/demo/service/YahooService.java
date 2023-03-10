package com.solvd.carina.demo.service;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.solvd.carina.demo.gui.pages.task.HomePage;
import com.solvd.carina.demo.gui.pages.task.LoginPasswordPage;
import com.solvd.carina.demo.gui.pages.task.LoginUsernamePage;
import org.testng.Assert;

public class YahooService implements IDriverPool {

    public HomePage homePageCheckServiceMethod() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(5), "Home page isn't opened");
        return homePage;
    }

    public LoginPasswordPage loginUserAndPasswordServiceMethod(String username, String password) {
        HomePage homePage = homePageCheckServiceMethod();
        LoginUsernamePage loginUsernamePage = homePage.clickLoginButton();
        Assert.assertTrue(loginUsernamePage.isPageOpened(5), "Login username page isn't opened");
        loginUsernamePage.fillUsername(username);
        LoginPasswordPage loginPasswordPage = loginUsernamePage.clickLoginUsernameButton();
        Assert.assertTrue(loginPasswordPage.isPageOpened(5), "Login password page isn't opened");
        loginPasswordPage.fillPassword(password);
        loginPasswordPage.clickLoginButton();
        return loginPasswordPage;
    }


}
