package com.solvd.carina.demo.mobile;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.mobile.gui.pages.task.android.CalendarPage;
import com.solvd.carina.demo.mobile.gui.pages.task.android.InfoPage;
import com.solvd.carina.demo.mobile.gui.pages.task.android.TaskPage;
import com.solvd.carina.demo.mobile.gui.pages.task.common.HomePageBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileTaskTest implements IAbstractTest, IMobileUtils {

    @Test()
    public void test() {
        HomePageBase hp = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(hp.isPageOpened());
        hp.clickNext();

        InfoPage infoPage = new InfoPage(getDriver());
        Assert.assertTrue(infoPage.isPageOpened());
        infoPage.clickGotItButton();

        CalendarPage calendarPage = new CalendarPage(getDriver());
        Assert.assertTrue(calendarPage.isPageOpened());
        calendarPage.clickPlusButton();
        calendarPage.clickTaskButton();

        TaskPage taskPage = new TaskPage(getDriver());
        Assert.assertTrue(taskPage.isPageOpened());
        taskPage.fillTitle("test");
        taskPage.clickSaveButton();
    }

}
