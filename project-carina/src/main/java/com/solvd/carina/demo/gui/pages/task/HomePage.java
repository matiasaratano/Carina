package com.solvd.carina.demo.gui.pages.task;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.components.task.FooterMenu;
import com.solvd.carina.demo.gui.components.task.SearchBoxItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HomePage extends AbstractPage {

    @FindBy(id = "ybarAccountProfile")
    private ExtendedWebElement loginButton;

    @FindBy(id = "root_3")
    private ExtendedWebElement sportsLabel;

    @FindBy(id = "module-footer")
    private FooterMenu footerMenu;

    @FindBy(id = "ybar-search-box-container")
    private SearchBoxItem searchBox;

    @FindBy(id = "ybar-navigation")
    private List<ExtendedWebElement> list;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginButton);
    }

    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

    public LoginUsernamePage clickLoginButton() {
        loginButton.click();
        return new LoginUsernamePage(getDriver());

    }

    public boolean isLoginButtonPresent() {
        return loginButton.isElementPresent();
    }

    public SportsPage clickSportsLabel() {
        sportsLabel.click();
        return new SportsPage(getDriver());
    }

    public void checkKeyPresenceInNavigation(String label) {
        for (ExtendedWebElement element : list) {
            if (element.getText().contains(label)) {
                element.click();
                break;
            }
        }

    }
}
