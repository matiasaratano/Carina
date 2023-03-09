package com.solvd.carina.demo.gui.pages.task;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.components.task.FooterMenu;
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

    @FindBy(id = "footer-wrapper")
    private ExtendedWebElement footer;

    @FindBy(id = "ybar-sbq")
    private ExtendedWebElement searchBox;

    @FindBy(id = "ybar-search")
    private ExtendedWebElement searchButton;


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

    public boolean checkUsernameLabel(String name) {
        return loginButton.getText().contains(name);
    }

    public void checkKeyPresenceInNavigation(String label) {
        for (ExtendedWebElement element : list) {
            if (element.getText().contains(label)) {
                element.click();
                break;
            }
        }
    }

    public NewsPage search(String subject) {
        this.searchBox.type(subject);
        this.searchButton.click();
        return new NewsPage(getDriver());
    }

    public void scrollToFooter() {
        footer.scrollTo();
    }

}
