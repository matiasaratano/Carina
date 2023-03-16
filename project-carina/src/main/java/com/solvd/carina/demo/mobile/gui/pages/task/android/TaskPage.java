package com.solvd.carina.demo.mobile.gui.pages.task.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.demo.mobile.gui.pages.task.common.TaskPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = TaskPageBase.class)
public class TaskPage extends TaskPageBase {


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

    @Override
    public void fillTitle(String title) {
        titleInput.type(title);
    }

    @Override
    public void clickSaveButton() {
        saveButton.click();
    }

}