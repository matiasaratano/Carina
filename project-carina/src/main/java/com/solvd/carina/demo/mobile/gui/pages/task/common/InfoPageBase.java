package com.solvd.carina.demo.mobile.gui.pages.task.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class InfoPageBase extends AbstractPage {
    public InfoPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CalendarPageBase clickGotItButton();
}
