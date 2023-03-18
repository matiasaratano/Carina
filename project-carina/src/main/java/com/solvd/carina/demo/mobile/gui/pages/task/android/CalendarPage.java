package com.solvd.carina.demo.mobile.gui.pages.task.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.demo.mobile.gui.pages.task.common.CalendarPageBase;
import com.solvd.carina.demo.mobile.gui.pages.task.common.TaskPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CalendarPageBase.class)
public class CalendarPage extends CalendarPageBase {

    @FindBy(id = "floating_action_button")
    private ExtendedWebElement plusButton;
    @FindBy(id = "tasks_speed_dial_container")
    private ExtendedWebElement taskButton;

    @FindBy(id = "og_apd_ring_view")
    private ExtendedWebElement userButton;


    @FindBy(id = "og_primary_account_information")
    private ExtendedWebElement userNameLabel;


    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return plusButton.isElementPresent();
    }

    @Override
    public void clickPlusButton() {
        plusButton.click();
    }

    @Override
    public TaskPageBase clickTaskButton() {
        taskButton.click();
        return initPage(getDriver(), TaskPageBase.class);
    }

    @Override
    public void clickUserButton() {
        userButton.click();
    }

    @Override
    public boolean isUserLabelPresent() {
        return userNameLabel.isElementPresent(5);
    }

    @Override
    public String getUsername() {
        return userNameLabel.getText();
    }
}