package com.solvd.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NewsItem extends AbstractUIObject {

    @FindBy(xpath = "//a[@data-matarget='algo']")
    public ExtendedWebElement titleLink;

    public NewsItem(WebDriver driver, SearchContext sc) {
        super(driver, sc);
    }

    public String readTitle() {
        return titleLink.getText();
    }
}
