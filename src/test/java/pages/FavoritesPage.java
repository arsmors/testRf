package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FavoritesPage {

    BaseFunc baseFunc;

    public FavoritesPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    private final By ADDTOFAVORITES = By.xpath("//li[@class=\"favourite\"]");
    private final By MEMOID = By.xpath("//span[@id=\"favorites_count\"]");
    private final By MEMOPAGES = By.xpath("//div[@class=\"price\"]");
    private final By FAVPAGE = By.xpath("//a[@id=\"favorites-link\"]");

    public String getMemoId() {
        return baseFunc.getElement(MEMOID).getText();
    }

    public void addToFavorites() throws InterruptedException {
        Thread.sleep(2000);
        baseFunc.getElement(ADDTOFAVORITES).click();
    }

    public void goToFavoritesPage() {
        baseFunc.getElement(FAVPAGE).click();
    }

    public void checkAllAdsDisplayedOnPage() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> listOfElements = baseFunc.getElements(MEMOPAGES);
        assertFalse("ads are not added to favorites", listOfElements.isEmpty());
    }

    public void checkMemoToolbarHasCount() {
        List<WebElement> listOfElements = baseFunc.getElements(MEMOPAGES);

        int ads = listOfElements.size();
        try {
            int memoToolbarId = Integer.parseInt(getMemoId().replaceAll("[^\\d.]", ""));
            assertEquals("memo toolbar is showing incorrect qty", ads, memoToolbarId);
        } catch (Exception e) {
            throw new NullPointerException("memo toolbar is empty or showing incorrect qty. Please check manually!");
        }
    }
}
