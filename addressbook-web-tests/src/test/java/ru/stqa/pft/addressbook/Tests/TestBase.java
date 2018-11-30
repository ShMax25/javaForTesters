package ru.stqa.pft.addressbook.Tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX)); // Now we can choose in which browser to run Tests, in settings we should specify browser if no it will use FF by default
  Logger logger = LoggerFactory.getLogger(TestBase.class);

/*
Suite daet vozmojnosti ispolizovati 1 brauzer dlia vseh testov
 */
  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite (alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

  @BeforeMethod
  public void  logTestStart(Method m, Object[] p) {
    logger.info("Start test "+ m.getName() + " with parameters: " + Arrays.asList(p));

  }

  @AfterMethod (alwaysRun = true)
  public void  logTestStop(Method m) {
    logger.info("Stop test "+ m.getName());

  }

}
