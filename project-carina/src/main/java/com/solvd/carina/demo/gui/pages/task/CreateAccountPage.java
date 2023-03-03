package com.solvd.carina.demo.gui.pages.task;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends AbstractPage {

    @FindBy(xpath = "//input[contains(@name, 'firstName')]")
    private ExtendedWebElement fullNameInput;

    @FindBy(xpath = "//input[contains(@name, 'userId')]")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//input[contains(@name, 'password')]")
    private ExtendedWebElement passwordInput;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void fillFullName(String fullname) {
        fullNameInput.type(fullname);
    }

    public void fullEmail(String email) {
        emailInput.type(email);
    }

    public void fillPassword(String password) {
        passwordInput.type(password);
    }

}
