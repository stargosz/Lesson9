package Tests;

import Pages.DropablePage;
import TestBase.TestBase;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.interactions.Actions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DroppableTest extends TestBase {
    DropablePage dropablePage = new DropablePage(getDriver());

    @ParameterizedTest
    @DisplayName("Open 'seleniumui.moderntester' web page")
    @Order(1)
    @ValueSource(strings = "Automation Pratice")
    public void shouldOpenWebPage(String title) {
        getDriver().get("https://seleniumui.moderntester.pl/droppable.php");
        String actualTitle = getDriver().getTitle();
        assertThat(actualTitle, is(title));
    }

    @ParameterizedTest
    @Order(2)
    @DisplayName("Drags 1st element and drops it on the 2nd one")
    @ValueSource(strings = "Dropped!")
    public void shouldDragAndDropElement(String expectedMessage) {
        Actions actions = new Actions(getDriver());
        int dragXvalue = dropablePage.getDrag().getLocation().getX();
        int dropXvalue = dropablePage.getDrop().getLocation().getX();
        int xValueDifference = dropXvalue - dragXvalue;
        actions.dragAndDropBy(dropablePage.getDrag(), xValueDifference, 0).build().perform();
        assertThat(dropablePage.getDropMessage().getText(), is(expectedMessage));

    }

}
