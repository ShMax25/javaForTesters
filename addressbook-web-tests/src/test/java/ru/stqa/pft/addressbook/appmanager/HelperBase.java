package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.File;


public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

/*
Veryfies if form contains some text, if we adding null as parameter
then we skip this form
 */
  protected void type(By locator, String text) {
    click(locator);
    if (text != null){
      String existingText = wd.findElement(locator).getAttribute("value"); // Comparing parameter with existing text in form
      if (! text.equals(existingText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }
//Method for adding img for contact
  protected void attach(By locator, File file) {
    if (file != null){
        wd.findElement(locator).sendKeys(file.getAbsolutePath());
      }
    }

  public boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
