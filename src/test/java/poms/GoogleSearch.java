package poms;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.ValidationEnums;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearch {
    WebDriver driver;

     String url = "https://www.google.com/ncr";
     String urlAfterRedirection = "https://www.google.com";
     
    public static By googleLogo_image = By.xpath("//*[@id='hplogo' or @alt='Google']");

    By searchBox_textField = By.xpath("//input[@id='lst-ib' or @class='lst' or @name='q']");

    public GoogleSearch(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToURL() {
        BrowserActions.navigateToURL(driver, url, urlAfterRedirection);
    }

    public void searchForQuery(String searchQuery) {
        ElementActions.type(driver, searchBox_textField, searchQuery);
        ElementActions.keyPress(driver, searchBox_textField, "Enter");
    }

    public void typeQuery(String searchQuery) {
        ElementActions.type(driver, searchBox_textField, searchQuery);
    }

    public void copyQuery() {
        ElementActions.clipboardActions(driver, searchBox_textField, "copy");
    }

    public void pasteQuery() {
        ElementActions.clipboardActions(driver, searchBox_textField, "paste");
    }

    public void cutQuery() {
        ElementActions.clipboardActions(driver, searchBox_textField, "cut");
    }

    public void selectQuery() {
        ElementActions.clipboardActions(driver, searchBox_textField, "select all");
    }

    public void unSelectQuery() {
        ElementActions.clipboardActions(driver, searchBox_textField, "unselect");
    }

    public void assertPageIsOpen() {
            Validations.assertThat()
                    .element(driver, googleLogo_image)
                    .exists()
                    .perform();
    }

    public void verifyPageTitle(String expectedValue) {
        Validations.verifyThat().browser(driver).title().isEqualTo(expectedValue).perform();
        Validations.verifyThat().browser(driver).title().doesNotEqual("Not Google").perform();
    }

}
