package com.solvd.carina.demo.gui.pages.task;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class SportsPage extends AbstractPage {


    @FindBy(id = "ybar-sbq")
    private ExtendedWebElement searchBox;

    @FindBy(id = "ybar-search")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//h1[contains(text(), 'Depor')]")
    private ExtendedWebElement yahooLabel;


    public SportsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(yahooLabel);
    }

    public NewsPage search(String subject) {
        this.searchBox.type(subject);
        this.searchButton.click();
        return new NewsPage(getDriver());
    }
}
