package com.solvd.carina.demo.gui.pages.task;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.components.NewsItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class SportsPage extends AbstractPage {


    @FindBy(id = "ybar-sbq")
    private ExtendedWebElement searchBox;

    @FindBy(id = "ybar-search")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//h1[contains(text(), 'Depor')]")
    private ExtendedWebElement yahooLabel;

    @FindBy(xpath = "//a[@data-matarget='algo']")
    private List<NewsItem> news;

    public SportsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(yahooLabel);
    }

    public NewsPage search(String subject) {
        this.searchBox.type(subject);
        this.searchButton.click();
        return new NewsPage(getDriver());
    }

    public List<NewsItem> searchNews(String subject) {
        searchBox.type(subject);
        searchButton.click();
        return news;
    }

}
