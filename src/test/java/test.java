import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class test {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test1() {
        driver.get("https://playground.learnqa.ru/puzzle/triangle");

        WebElement giveUpButton = driver.findElement(By.xpath("//button[text()='Я сдаюсь']"));
        assertTrue(giveUpButton.isDisplayed(), "Кнопка 'Я сдаюсь' не найдена");

        giveUpButton.click();

        WebElement answerLink = driver.findElement(By.linkText("Ссылка на ответы"));
        assertTrue(answerLink.isDisplayed(), "Ссылка 'Ссылка на ответы' не найдена");

        WebElement hideAnswersButton = driver.findElement(By.xpath("//button[text()='Спрятать ответы']"));
        assertTrue(hideAnswersButton.isDisplayed(), "Кнопка 'Спрятать ответы' не найдена");
    }
}