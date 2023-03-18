package com.solvd.carina.demo.mobile.gui.pages.task.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CalendarPageBase extends AbstractPage {
    public CalendarPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickPlusButton();

    public abstract TaskPageBase clickTaskButton();

    public abstract void clickUserButton();

    public abstract boolean isUserLabelPresent();

    public abstract String getUsername();

}
