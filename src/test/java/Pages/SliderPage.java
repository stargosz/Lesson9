package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SliderPage {

    WebDriver driver;

    public SliderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div#custom-handle")
    WebElement slider;

    public WebElement getSlider() {
        return slider;
    }

    public void setSlider(Keys keys) {
        slider.sendKeys(keys);
    }


    public int getActualValue() {
        int actualValue = Integer.parseInt(getSlider().getText());
        return actualValue;
    }

    public void moveTo(int expectedValue) {
        if (expectedValue > getActualValue()) {
            for (int i = getActualValue(); i < expectedValue; i++) {
                setSlider(Keys.ARROW_RIGHT);
            }
            assertThat(getActualValue(), is(expectedValue));
        } else if (expectedValue < getActualValue()) {
            for (int i = getActualValue(); i > expectedValue; i--) {
                setSlider(Keys.ARROW_LEFT);
            }
            assertThat(getActualValue(), is(expectedValue));
        }
    }

    public void moveToZeroValue() {
        for (int i = getActualValue(); i > 0; i--) {
            setSlider(Keys.ARROW_LEFT);
        }
        assertThat(getActualValue(), is(0));
    }
}
