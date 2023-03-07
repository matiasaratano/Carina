package com.solvd.carina.demo.gui.components.task;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FooterMenu extends AbstractUIObject {


    @FindBy(xpath = "//svg[@data-icon='LogoTwitter']")
    private ExtendedWebElement twitterIcon;

    @FindBy(xpath = "//svg[@data-icon='LogoFacebook']")
    private ExtendedWebElement facebookIcon;

    @FindBy(xpath = "//svg[@data-icon='LogoInstagramEmblem1']")
    private ExtendedWebElement instagramIcon;


    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickTwitter() {
        twitterIcon.click();
    }

    public void clickFacebook() {
        facebookIcon.click();
    }

    public void clickInstagram() {
        instagramIcon.click();
    }
}
