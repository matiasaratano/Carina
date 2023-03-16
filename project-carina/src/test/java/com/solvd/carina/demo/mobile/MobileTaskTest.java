package com.solvd.carina.demo.mobile;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.mobile.gui.pages.task.common.CalendarPageBase;
import com.solvd.carina.demo.mobile.gui.pages.task.common.HomePageBase;
import com.solvd.carina.demo.mobile.gui.pages.task.common.InfoPageBase;
import com.solvd.carina.demo.mobile.gui.pages.task.common.TaskPageBase;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileTaskTest implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "maratano")
    public void testCreateNewTask() {
        HomePageBase hp = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(hp.isPageOpened());

        InfoPageBase infoPage = hp.clickNext();
        Assert.assertTrue(infoPage.isPageOpened());

        CalendarPageBase calendarPage = infoPage.clickGotItButton();
        Assert.assertTrue(calendarPage.isPageOpened());
        calendarPage.clickPlusButton();

        TaskPageBase taskPage = calendarPage.clickTaskButton();
        Assert.assertTrue(taskPage.isPageOpened());
        taskPage.fillTitle(R.TESTDATA.get("mobile_test"));
        taskPage.clickSaveButton();
        Assert.assertTrue(calendarPage.isPageOpened(), "Calendar page isn't opened");
    }

}
