package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://tomaszpietkun.github.io/";
    private WebDriver driver;
    private Random generator;

    @Before
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get(BASE_URL);
        generator = new Random();
    }


    public void cleanYpAfterTest() {
        driver.close();
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "/html/body/main/section[1]/form/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "/html/body/main/section[1]/form/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "/html/body/main/section[1]/form/fieldset[3]/button";

        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        Thread.sleep(2000);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();

        driver.navigate().refresh();

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while(!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(By.xpath("//form[@class=\"datable_row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datable_field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        Thread.sleep(5000);
    }

    public boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driverTrello.get(TRELLO_URL);

        driverTrello.findElement(By.id("user")).sendKeys("tomasz.pietkun.99@gmail.com");
        driverTrello.findElement(By.id("password")).sendKeys("1999Tomp?");
        driverTrello.findElement(By.id("login")).submit();

        Thread.sleep(2000);

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//span[@title=\"Kodilla Board\"]")).size() > 0)
                .forEach(aHref -> aHref.click());

        Thread.sleep(2000);

        result = driverTrello.findElements(By.xpath("//span[contains(@class, \"list-card-title\")]")).stream()
                .filter(theSpan -> theSpan.getText().contains(taskName))
                .collect(Collectors.toList())
                .size() > 0;

        driverTrello.close();
        return result;
    }

    public boolean deleteTaskFromCrud(String taskName) throws InterruptedException {

        final String XPATH_TASK_BY_NAME = "//p[contains(@data-task-name-paragraph,\"" + taskName + "\")]";


        while(!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(By.xpath("//form[@class='datatable__row']")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText().contains(taskName))
                .collect(Collectors.toList()).stream()
                .forEach(theForm -> {
                    WebElement buttonDelete = theForm.findElement(By.xpath(".//button[4]"));
                    buttonDelete.click();
                });

        driver.navigate().refresh();
        boolean result = (driver.findElements(By.xpath(XPATH_TASK_BY_NAME)).isEmpty());

        return result;
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        boolean deleteTask = deleteTaskFromCrud(taskName);

        assertTrue(deleteTask);

    }
}