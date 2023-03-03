package com.solvd.carina.demo.gui.pages.task;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {


    @FindBy(xpath = "//input[contains(@id, 'login-username')]")
    private ExtendedWebElement usernameLabel;

    @FindBy(xpath = "//input[contains(@id, 'login-signin')]")
    private ExtendedWebElement loginSigninButton;

    @FindBy(xpath = "//div[contains(@class, 'recaptcha-checkbox-border-label')]")
    private ExtendedWebElement captchaCheckbox;

    @FindBy(xpath = "//button[contains(@id, 'recaptcha-submit')]")
    private ExtendedWebElement captchaButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginEmailButtonPresent() {
        return loginSigninButton.isElementPresent();
    }

    public void fillUsername(String username) {
        usernameLabel.type(username);
    }

    public RegisterPage clickLoginUsernameButton() {
        loginSigninButton.click();
        return new RegisterPage(getDriver());
    }
}
