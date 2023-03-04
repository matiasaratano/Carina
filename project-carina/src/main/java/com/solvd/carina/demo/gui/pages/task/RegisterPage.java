package com.solvd.carina.demo.gui.pages.task;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends AbstractPage {
    @FindBy(xpath = "//a[contains(text(), 'Regist')]")
    private ExtendedWebElement registerButton;


    public RegisterPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(registerButton);
    }

    public CreateAccountPage clickRegisterButton() {
        registerButton.click();
        return new CreateAccountPage(getDriver());
    }
}
