package com.solvd.carina.demo.gui.components.task;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NewsItem extends AbstractUIObject {

    @FindBy(xpath = "./a")
    public ExtendedWebElement titleLink;

    public String readTitle() {
        return titleLink.getElement().getText();
    }

    public NewsItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
