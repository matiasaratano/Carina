package com.solvd.carina.demo.mobile.gui.pages.task.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class TaskPageBase extends AbstractPage {

    public TaskPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void fillTitle(String title);

    public abstract void clickSaveButton();
}