package Tests;

import Pages.SliderPage;
import TestBase.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SliderTest extends TestBase {

    SliderPage sliderPage = new SliderPage(getDriver());

    @ParameterizedTest
    @DisplayName("Open 'seleniumui.moderntester' web page")
    @Order(1)
    @ValueSource(strings = "Automation Pratice")
    public void shouldOpenWebPage(String title) {
        getDriver().get("https://seleniumui.moderntester.pl/slider.php");
        String actualTitle = getDriver().getTitle();
        assertThat(actualTitle, is(title));
    }
    @Test
    @Order(2)
    @DisplayName("Moves slider to given value")
    public void shouldMoveSliderTo50(){
        sliderPage.moveTo(0);
        sliderPage.moveTo(50);
        sliderPage.moveTo(30);
        sliderPage.moveTo(30);
        sliderPage.moveTo(80);
    }

}
