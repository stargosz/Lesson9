package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {

    WebDriver driver;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#prompt-alert")
    WebElement promptAlertButton;

    @FindBy(css = "#prompt-label")
    WebElement promptAlertMessage;

    @FindBy(css = "#confirm-alert")
    WebElement confirmAlertButton;

    @FindBy(css = "#confirm-label")
    WebElement confirmAlertMessage;

    public WebElement getConfirmAlertButton() {
        return confirmAlertButton;
    }

    public void clickConfirmAlertButton() {
        confirmAlertButton.click();
    }

    public WebElement getConfirmAlertMessage() {
        return confirmAlertMessage;
    }


    public WebElement getPromptAlertButton() {
        return promptAlertButton;
    }

    public void clickPromptAlertButton() {
        promptAlertButton.click();
    }

    public WebElement getPromptAlertMessage() {
        return promptAlertMessage;
    }


}
