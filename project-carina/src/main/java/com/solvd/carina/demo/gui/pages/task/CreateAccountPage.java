package com.solvd.carina.demo.gui.pages.task;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends AbstractPage {

    @FindBy(name = "firstName")
    private ExtendedWebElement fullNameInput;

    @FindBy(name = "userId")
    private ExtendedWebElement emailInput;

    @FindBy(name = "password")
    private ExtendedWebElement passwordInput;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(fullNameInput);
    }

    public void fillAccountDetails(String fullname, String email, String password) {
        fullNameInput.type(fullname);
        emailInput.type(email);
        passwordInput.type(password);
    }

}
