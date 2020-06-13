package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class HomePage {
    BaseFunc baseFunc;
    WebDriver driver;
    Actions action;

    Consumer<By> hover = (By by) -> {
        action.moveToElement(driver.findElement(by))
                .perform();
    };

    public String homePage = "https://reklama.bb.lv/ru/";
    private final By MAIN = By.xpath("//td[@class=\"img\"]");
    private final By MAIN_MENU = By.xpath("//*[@class=\"menu_main\"]");
    private final By CHECKBOX = By.xpath("//a[@class=\"fav-add\"]");
    private final By ADS = By.xpath("//tr[@onmouseover=\"this.className = 'over'\"]");
    private final By AddToFavIcon = By.xpath("//tr[contains(@class,'over')]//a[@class='fav-add']");
    private final By AddToFavIcon2 = By.xpath("//a[@class='fav-add']");

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void openHomePage(String category) {
        baseFunc.openPage(homePage + category);
    }

    public void chooseRandomAdFromList() throws InterruptedException {
        Random num = new Random();
        int id = num.nextInt(10);
        Thread.sleep(2000);
        getItems(id).click();
    }

    public void chooseMultipleAdsFromList(int ads) {
        List<WebElement> items = baseFunc.getElements(CHECKBOX);
        for (int i = 0; i < ads; i++) {
            items.get(i).click();
        }
    }

    public void addAds(int ads) throws InterruptedException {
        List<WebElement> items = baseFunc.getElements(ADS);
        for (int i = 0; i < ads; i++) {
            Actions builder = new Actions(baseFunc.driver);
            builder.moveToElement(items.get(i)).perform();
            JavascriptExecutor executor = (JavascriptExecutor) baseFunc.driver;
            Thread.sleep(3000);
            executor.executeScript("arguments[0].click();", baseFunc.getElement(AddToFavIcon));
        }
    }

    private WebElement getItems(int id) {
        List<WebElement> items = baseFunc.getElements(MAIN);
        return items.get(id);
    }

//    public void selectMenuItem(String item) {
//        List<WebElement> menuItems = baseFunc.getElements(MAIN_MENU);
//        for (int i = 0; i < menuItems.size(); i++) {
//            if (menuItems.get(i).getText().equals(item)) {
//                menuItems.get(i).click();
//                break;
//            }
//        }
//    }
}
