package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
import java.util.Random;

public class HomePage {
    BaseFunc baseFunc;

    public String homePage = "https://reklama.bb.lv/ru/";
    private final By MAIN = By.xpath("//td[@class=\"img\"]");
    private final By ADS = By.xpath("//tr[@onmouseover=\"this.className = 'over'\"]");
    private final By AddToFavIcon = By.xpath("//tr[contains(@class,'over')]//a[@class='fav-add']");
    private final By RemoveFromFavIcon = By.xpath("//tr[contains(@class,'over')]//a[@class='fav-remove']");

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void openHomePage(String category) {
        baseFunc.openPage(homePage + category);
    }

    public void chooseRandomAdFromList() {
        Random num = new Random();
        int id = num.nextInt(10);
        baseFunc.waitPageisFullyLoaded(baseFunc.driver);
        getItems(id).click();
    }

    public void addAds(String addRemove, int ads) {
        List<WebElement> items = baseFunc.getElements(ADS);

        for (int i = 0; i < ads; i++) {
            Actions builder = new Actions(baseFunc.driver);
            builder.moveToElement(items.get(i)).perform();
            JavascriptExecutor executor = (JavascriptExecutor) baseFunc.driver;
//            Thread.sleep(3000);
            if(addRemove.equals("add")) {
                executor.executeScript("arguments[0].click();", baseFunc.getElement(AddToFavIcon));
            } else {
                executor.executeScript("arguments[0].click();", baseFunc.getElement(RemoveFromFavIcon));
            }
        }
    }

    private WebElement getItems(int id) {
        List<WebElement> items = baseFunc.getElements(MAIN);
        return items.get(id);
    }
}
