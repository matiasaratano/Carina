package com.solvd.carina.demo.gui.pages.task;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginUsernamePage extends AbstractPage {


    @FindBy(id = "login-username")
    private ExtendedWebElement usernameLabel;

    @FindBy(id = "login-signin")
    private ExtendedWebElement loginSigninButton;

    @FindBy(css = "div.recaptcha-checkbox-border-label")
    private ExtendedWebElement captchaCheckbox;

    @FindBy(id = "recaptcha-submit")
    private ExtendedWebElement captchaButton;

    public LoginUsernamePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginSigninButton);
    }

    public boolean isLoginEmailButtonPresent() {
        return loginSigninButton.isElementPresent();
    }

    public void fillUsername(String username) {
        usernameLabel.type(username);
    }

    public LoginPasswordPage clickLoginUsernameButton() {
        loginSigninButton.click();
        return new LoginPasswordPage(getDriver());
    }
}
