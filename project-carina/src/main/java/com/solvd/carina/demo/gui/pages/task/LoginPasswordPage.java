package com.solvd.carina.demo.gui.pages.task;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPasswordPage extends AbstractPage {

    @FindBy(id = "login-passwd")
    private ExtendedWebElement passLabel;

    @FindBy(id = "login-signin")
    private ExtendedWebElement loginSigninButton;

    @FindBy(css = "p.error-msg")
    private ExtendedWebElement wrongPasswordLabel;

    public LoginPasswordPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginSigninButton);
    }

    public void clickLoginButton() {
        loginSigninButton.click();
    }

    public boolean isWrongPassLabelPresent() {
        return wrongPasswordLabel.isElementPresent();
    }

    public void fillPassword(String pass) {
        passLabel.type(pass);
    }


}
