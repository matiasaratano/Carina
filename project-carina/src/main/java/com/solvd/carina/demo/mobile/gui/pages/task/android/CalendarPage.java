package com.solvd.carina.demo.mobile.gui.pages.task.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CalendarPage extends AbstractPage {

    @FindBy(id = "floating_action_button")
    private ExtendedWebElement plusButton;
    @FindBy(id = "tasks_speed_dial_container")
    private ExtendedWebElement taskButton;


    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return plusButton.isElementPresent();
    }

    public void clickPlusButton() {
        plusButton.click();
    }

    public void clickTaskButton() {
        taskButton.click();
    }
}