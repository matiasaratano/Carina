package com.solvd.carina.demo.mobile.gui.pages.task.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.demo.mobile.gui.pages.task.common.CalendarPageBase;
import com.solvd.carina.demo.mobile.gui.pages.task.common.InfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = InfoPageBase.class)
public class InfoPage extends InfoPageBase {

    @FindBy(id = "oobe_done_button")
    private ExtendedWebElement gotItButton;

    public InfoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return gotItButton.isElementPresent();
    }

    @Override
    public CalendarPageBase clickGotItButton() {
        gotItButton.click();
        return initPage(getDriver(), CalendarPageBase.class);
    }
}
