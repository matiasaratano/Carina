package com.solvd.carina.demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.junit.Assert;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class CondidateBlock extends AbstractUIObject {
    @FindBy(xpath = ".//input[contains(@id, 'sSearch')]")
    private ExtendedWebElement inputField;

    @FindBy(xpath = "./div[contains(@class, 'autocomplete-search')]//a[not(@class)]")
    private List<ExtendedWebElement> autocompleteSearchElements;

    public CondidateBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void sendKeysToInputField(String text) {
        inputField.click();
        inputField.type(text);
    }

    public void getFirstPhone() {
		pause(1);
		Assert.assertTrue("No phones found!", autocompleteSearchElements.size() > 0);
		autocompleteSearchElements.get(0).assertElementPresent();
        autocompleteSearchElements.get(0).click();
    }
}
