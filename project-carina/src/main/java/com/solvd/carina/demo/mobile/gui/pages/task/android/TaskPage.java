package com.solvd.carina.demo.mobile.gui.pages.task.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TaskPage extends AbstractPage {


    @FindBy(id = "title")
    private ExtendedWebElement titleInput;

    @FindBy(id = "save")
    private ExtendedWebElement saveButton;


    public TaskPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return titleInput.isElementPresent();
    }

    public void fillTitle(String title) {
        titleInput.type(title);
    }

    public void clickSaveButton() {
        saveButton.click();
    }
}