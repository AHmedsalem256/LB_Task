package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class LandingPage extends BasePage {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(id = "gh-f")
    WebElement SearchBar;
    @FindBy(xpath = "//*[@id='gh']/section/div")
    WebElement Logo;
    @FindBy(id = "gh-search-btn")
    private WebElement searchButton;

    // Methods
    public void validateLogo() {
        Assert.assertTrue(
                Logo.isDisplayed(),
                "Logo is not displayed!"
        );
    }

    public void ValidateSearchBar(){
        Assert.assertTrue(
                SearchBar.isDisplayed(),
                "SearchBar is not displayed!"
        );
    }

    public void TypeSearchBar(String SearchWord){
        SearchBar.sendKeys(SearchWord);
        searchButton.click();
    }

    /**
     * Validates that every search result card title contains "mazdamx-5".
     */
    public void validateAllCardsContainMazdamx5(String Target_Word) {
        // Wait for result cards to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector("ul.srp-results > li.s-card")
        ));

        List<WebElement> cards = driver.findElements(
                By.cssSelector("ul.srp-results > li.s-card")
        );

        Assert.assertFalse(cards.isEmpty(), "No search result cards found!");

        for (WebElement card : cards) {
            // Skip the pagination row
            String cls = card.getAttribute("class");
            if (cls != null && cls.contains("srp-river-answer")) {
                continue;
            }

            // Get title text
            String title;
            try {
                title = card.findElement(
                        By.cssSelector(".s-card__title .su-styled-text.primary")
                ).getText();
            } catch (Exception e) {
                title = "";
            }

            Assert.assertTrue(
                    title.toLowerCase().contains(Target_Word),
                    "Card title does not contain 'mazdamx-5': " + title
            );
        }
    }
}