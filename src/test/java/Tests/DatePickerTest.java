package Tests;

import Pages.DatePickerPage;
import TestBase.TestBase;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DatePickerTest extends TestBase {

    DatePickerPage datePickerPage = new DatePickerPage(getDriver());
    LocalDate dateNow = LocalDate.now();


    @ParameterizedTest
    @DisplayName("Open 'seleniumui.moderntester' web page")
    @Order(1)
    @ValueSource(strings = "Automation Pratice")
    public void shouldOpenWebPage(String title) {
        getDriver().get("https://seleniumui.moderntester.pl/datepicker.php");
        String actualTitle = getDriver().getTitle();
        assertThat(actualTitle, is(title));
    }

    @Test
    @DisplayName("Selects '05/29/2021' date on calendar")
    @Order(2)
    public void shouldPickDate1() {
        datePickerPage.clickOnDatePickerInput();
        datePickerPage.setDate("29","May", "2021");
        assertThat(datePickerPage.getDatePickerInput().getAttribute("value"), is("05/29/2021"));
    }
    @Test
    @DisplayName("Selects '02/05/2021' date on calendar")
    @Order(3)
    public void shouldPickDate2() {
        datePickerPage.clearDatePickerInput();
        datePickerPage.clickOnDatePickerInput();
        datePickerPage.setDateInPast("5","February", "2021");
        assertThat(datePickerPage.getDatePickerInput().getAttribute("value"), is("02/05/2021"));
    }
    @Test
    @DisplayName("Selects '02/05/2021' date on calendar")
    @Order(4)
    public void shouldPickDate3() {
        datePickerPage.clearDatePickerInput();
        datePickerPage.clickOnDatePickerInput();
        datePickerPage.setDateInPast("5","February", "2021");
        assertThat(datePickerPage.getDatePickerInput().getAttribute("value"), is("02/05/2021"));
    }
    @Test
    @DisplayName("Selects '11/01/2020' date on calendar")
    @Order(5)
    public void shouldPickDate4() {
        datePickerPage.clearDatePickerInput();
        datePickerPage.clickOnDatePickerInput();
        datePickerPage.setDateInPast("1","November", "2020");
        assertThat(datePickerPage.getDatePickerInput().getAttribute("value"), is("11/01/2020"));
    }
    @Test
    @DisplayName("Selects '12/01/2020' date on calendar")
    @Order(6)
    public void shouldPickDate5() {
        datePickerPage.clearDatePickerInput();
        datePickerPage.clickOnDatePickerInput();
        datePickerPage.setDateInPast("1","December", "2020");
        assertThat(datePickerPage.getDatePickerInput().getAttribute("value"), is("12/01/2020"));
    }
    @Test
    @DisplayName("Selects '12/25/2020' date on calendar")
    @Order(7)
    public void shouldPickDate6() {
        datePickerPage.clearDatePickerInput();
        datePickerPage.clickOnDatePickerInput();
        datePickerPage.setDateInPast("25","December", "2020");
        assertThat(datePickerPage.getDatePickerInput().getAttribute("value"), is("12/25/2020"));
    }
    @Test
    @DisplayName("Selects '02/01/2020' date on calendar")
    @Order(8)
    public void shouldPickDate7() {
        datePickerPage.clearDatePickerInput();
        datePickerPage.clickOnDatePickerInput();
        datePickerPage.setDateInPast("1","February", "2020");
        assertThat(datePickerPage.getDatePickerInput().getAttribute("value"), is("02/01/2020"));
    }

    @Test
    @DisplayName("Selects today's date on calendar")
    @Order(9)
    public void shouldPickTodaysDate() {
        datePickerPage.clearDatePickerInput();
        datePickerPage.clickOnDatePickerInput();
        datePickerPage.setTodaysDate();
        String fullCurrentDate = DateTimeFormatter.ofPattern("MM/dd/yyyy").format(dateNow);
        assertThat(datePickerPage.getDatePickerInput().getAttribute("value"), is(fullCurrentDate));
    }
}