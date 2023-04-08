package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OpenPage extends BasePage{
    public OpenPage(WebDriver driver) {
        super(driver);
    }
     By languageIcon = By.xpath("//ul/li[contains(@class,'dropdown')]/a[contains(@href,'#')]/span[contains(.,'English')]");
     By englishLanguage = By.xpath("//ul[contains(@class,'dropdown-menu languages')]/li/a[contains(@href,'https://www.nagwa.com/en/')]");

     By searchIcon = By.xpath("//button[@type='button']");
     By textBox = By.id("txt_search_query");
     By searchButton = By.id("btn_global_search");
     By firstLessonTitle = By.xpath("//div[contains(@class,'right')][contains(.,'The Addition Symbol')]");
     By secondLesson = By.xpath("/html/body/div/div/div/div/main/div[3]/ul/li[2]/div/a");
     By secondLessonTitle= By.xpath("//div/h1[contains(.,'Lesson: Addition Polymerization')]");
     By lessonWorksheetButton = By.xpath("//li/div/a[contains(.,'Lesson Worksheet')]");
     By lessonWorksheetTitle = By.xpath("//div/h1[contains(.,'Lesson Worksheet')]");



    public void clickOnLanguageIcon() throws InterruptedException{
        click(languageIcon);
    }
    public void selectEnglishLanguage() throws InterruptedException{
        Thread.sleep(15);
        click(englishLanguage);
    }
    public void clickOnSearchIcon() throws InterruptedException{
        click(searchIcon);
    }
    public void setTheSearchValue() throws InterruptedException{
        setText(textBox,"addition");
    }
    public void clickOnSearchButton() throws InterruptedException{
        click(searchButton);
    }
    public String getFirstLessonTitle() throws InterruptedException {
        waitElement (firstLessonTitle);
        return getContent (firstLessonTitle);
    }
    public void clickOnSecondLesson() throws InterruptedException {
        click(secondLesson);
    }
    public String getSecondLessonTitle() throws InterruptedException{
        waitElement (secondLessonTitle);
        return getContent (secondLessonTitle);
    }
    public void clickOnWorksheetButton()throws InterruptedException{
        click(lessonWorksheetButton);
    }
    public String getWorksheetPageTitle() throws InterruptedException{
        waitElement (lessonWorksheetTitle);
        return getContent (lessonWorksheetTitle);
    }

    public int getTheNumberOfQuestions(){
        List <WebElement> questions = driver.findElements(By.xpath("//div/div[contains(@class,'instance')]"));
        int size = questions.size();
        System.out.println(size);
        return size;
        }
    }


