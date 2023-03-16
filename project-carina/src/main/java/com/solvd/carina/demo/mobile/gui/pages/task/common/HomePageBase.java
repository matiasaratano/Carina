package com.solvd.carina.demo.mobile.gui.pages.task.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver webDriver) {
        super(webDriver);
    }

    public abstract InfoPageBase clickNext();

}