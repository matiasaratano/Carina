package com.solvd.carina.demo.gui.pages.task;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.components.task.FooterMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class HomePage extends AbstractPage {

    @FindBy(id = "ybarAccountProfile")
    private ExtendedWebElement loginButton;

    @FindBy(id = "root_3")
    private ExtendedWebElement sportsLabel;

    @FindBy(id = "module-footer")
    private FooterMenu footerMenu;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginButton);
    }

    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(getDriver());

    }

    public boolean isLoginButtonPresent() {
        return loginButton.isElementPresent();
    }

    public void clickSportsLabel() {
        sportsLabel.click();
    }
}
