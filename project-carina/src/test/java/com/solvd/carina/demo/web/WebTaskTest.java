package com.solvd.carina.demo.web;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.carina.demo.gui.components.NewsItem;
import com.solvd.carina.demo.gui.pages.task.*;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertTrue;


public class WebTaskTest extends AbstractTest {

    @Test
    @MethodOwner(owner = "maratano")
    public void testLogInUserSuccesfully() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.assertPageOpened(5);
        assertTrue(homePage.isLoginButtonPresent(), "Login button isn't present");

        LoginUsernamePage loginUsernamePage = homePage.clickLoginButton();
        loginUsernamePage.assertPageOpened(5);
        loginUsernamePage.fillUsername(R.TESTDATA.get("user_3_username"));

        LoginPasswordPage loginPasswordPage = loginUsernamePage.clickLoginUsernameButton();
        loginPasswordPage.assertPageOpened(5);
        loginPasswordPage.fillPassword(R.TESTDATA.get("user_3_password"));
        loginPasswordPage.clickLoginButton();

        Assert.assertTrue(homePage.checkUsernameLabel(R.TESTDATA.get("user_3_name")));
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
    }

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

    @Test()
    @MethodOwner(owner = "maratano")
    public void testDesktopWidthAndHeight() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(String.valueOf(homePage.getDevice().getDeviceType()), "DESKTOP");
        softAssert.assertEquals(String.valueOf(getDriver().manage().window().getSize().getWidth() >= 1024), "true");
        softAssert.assertEquals(String.valueOf(getDriver().manage().window().getSize().getHeight() >= 800), "true");
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "maratano")
    public void testSearchCheckNewsTitles() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        NewsPage newsPage = homePage.search(R.TESTDATA.get("test_first_search"));
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");

        List<NewsItem> news = newsPage.searchNews(R.TESTDATA.get("test_second_search"));
        Assert.assertFalse(CollectionUtils.isEmpty(news), "News not found!");
        SoftAssert softAssert = new SoftAssert();
        for (NewsItem n : news) {
            softAssert.assertTrue(StringUtils.containsIgnoreCase(n.readTitle(), R.TESTDATA.get("test_second_search")),
                    "Invalid search results for " + n.readTitle());
        }
        softAssert.assertAll();
    }

    @Test(dataProvider = "searchTerms", description = "Test Yahoo search functionality")
    @MethodOwner(owner = "maratano")
    public void testOpenAndSearchInSportPage(String searchTerm) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(5), "Home page isn't opened");

        SportsPage sportsPage = homePage.clickSportsLabel();
        Assert.assertTrue(sportsPage.isPageOpened(5), "Sports page isn't opened");

        NewsPage newsPage = sportsPage.search(searchTerm);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(newsPage.isPageOpened(5), "News page is not opened!");
        softAssert.assertAll();
    }

    @DataProvider(name = "searchTerms")
    public static Object[][] searchTermsDataProvider() {
        return new Object[][]{
                {"Boca"},
                {"River"},
                {"Estudiantes"}
        };
    }
}
