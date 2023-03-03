package com.solvd.carina.demo.gui.pages.task;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.components.task.FooterMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class HomePage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@id, 'ybarAccountProfile')]")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//div[contains(@id, 'module-footer')]")
    private FooterMenu footerMenu;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.yahoo.com/");
    }

    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(getDriver());
    }
}
