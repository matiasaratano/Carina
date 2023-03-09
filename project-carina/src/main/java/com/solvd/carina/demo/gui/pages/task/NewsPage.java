package com.solvd.carina.demo.gui.pages.task;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.components.NewsItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsPage extends AbstractPage {

    @FindBy(xpath = "//input[@type='text']")
    private ExtendedWebElement searchTextField;

    @FindBy(xpath = "//input[@type='submit']")
    private ExtendedWebElement searchButton;

    //@FindBy(className = "compTitle")
    @FindBy(xpath = "//a[@data-matarget='algo']")
    private List<NewsItem> news;

    public NewsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(searchTextField);
    }

    public List<NewsItem> searchNews(String q) {
        searchTextField.type(q);
        searchButton.click();
        return news;
    }

}
