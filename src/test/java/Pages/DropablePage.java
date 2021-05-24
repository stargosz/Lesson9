package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropablePage {

    WebDriver driver;

    public DropablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#draggable")
    WebElement drag;

    @FindBy(css = "#droppable")
    WebElement drop;

    @FindBy(css = "#droppable p")
    WebElement dropMessage;

    public WebElement getDropMessage() {
        return dropMessage;
    }

    public WebElement getDrag() {
        return drag;
    }

    public WebElement getDrop() {
        return drop;
    }
}
