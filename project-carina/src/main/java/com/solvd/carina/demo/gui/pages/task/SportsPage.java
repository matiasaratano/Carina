package com.solvd.carina.demo.gui.pages.task;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.components.task.SearchBoxItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class SportsPage extends AbstractPage {


    @FindBy(id = "ybar-search-box-container")
    private SearchBoxItem searchBox;

    @FindBy(xpath = "//h1[contains(text(), 'Depor')]")
    private ExtendedWebElement yahooLabel;


    public SportsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(yahooLabel);
    }
}
