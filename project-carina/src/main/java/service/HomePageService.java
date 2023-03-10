package service;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.solvd.carina.demo.gui.pages.task.HomePage;
import com.solvd.carina.demo.gui.pages.task.LoginPasswordPage;
import com.solvd.carina.demo.gui.pages.task.LoginUsernamePage;
import org.testng.Assert;

public class HomePageService implements IDriverPool {

    public HomePage loginService(String username, String password) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");

        LoginUsernamePage loginUsernamePage = homePage.clickLoginButton();
        Assert.assertTrue(loginUsernamePage.isPageOpened(), "Login username page isn't opened");
        loginUsernamePage.fillUsername(username);

        LoginPasswordPage loginPasswordPage = loginUsernamePage.clickLoginUsernameButton();
        Assert.assertTrue(loginPasswordPage.isPageOpened(), "Login password page isn't opened");
        loginPasswordPage.fillPassword(password);
        loginPasswordPage.clickLoginButton();
        return homePage;
    }
}
