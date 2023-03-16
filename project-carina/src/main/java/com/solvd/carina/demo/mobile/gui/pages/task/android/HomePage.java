package com.solvd.carina.demo.mobile.gui.pages.task.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.demo.mobile.gui.pages.task.common.HomePageBase;
import com.solvd.carina.demo.mobile.gui.pages.task.common.InfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(id = "image")
    private ExtendedWebElement icon;

    @FindBy(id = "next_arrow")
    private ExtendedWebElement nextButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public boolean isPageOpened() {
        return icon.isElementPresent();
    }

    @Override
    public InfoPageBase clickNext() {
        nextButton.click();
        return initPage(getDriver(), InfoPageBase.class);
    }


}
