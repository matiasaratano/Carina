package com.solvd.carina.demo.mobile.gui.pages.task.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class InfoPage extends AbstractPage {

    @FindBy(id = "oobe_done_button")
    private ExtendedWebElement gotItButton;

    public InfoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return gotItButton.isElementPresent();
    }

    public void clickGotItButton() {
        gotItButton.click();
    }
}
