import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

//import org.junit.After;
//import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Test1 {
  private static WebDriver driver;
  private static String baseUrl;

  @BeforeClass
  public static void setUp() throws Exception {
	String pathToGeckoDriver = Paths.get("geckodriver.exe").toAbsolutePath().toString();
	System.setProperty("webdriver.gecko.driver", pathToGeckoDriver); 
    driver = new FirefoxDriver();
    baseUrl = "https://www.mail.ru";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test1() throws Exception {
	driver.get(baseUrl + "/");
    driver.findElement(By.id("mailbox__login")).clear();
    driver.findElement(By.id("mailbox__login")).sendKeys("gfhgfhfh");
    driver.findElement(By.id("mailbox__password")).clear();
    driver.findElement(By.id("mailbox__password")).sendKeys("ghgfh");
    driver.findElement(By.id("mailbox__auth__button")).click();  
    TimeUnit.SECONDS.sleep(3);
  }
  
  @Test
  public void test2() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("mailbox__login")).clear();
    driver.findElement(By.id("mailbox__login")).sendKeys("val_lane@list.ru");
    driver.findElement(By.id("mailbox__password")).clear();
    driver.findElement(By.id("mailbox__password")).sendKeys("******");
    driver.findElement(By.id("mailbox__auth__button")).click();  
    TimeUnit.SECONDS.sleep(3);
  }
  
  @Test
  public void test3() throws Exception {
	    driver.findElement(By.id("portal-menu__search")).sendKeys("val_lane@list.ru");
	    driver.findElement(By.id("PH_logoutLink")).click();


  }
  @Test
  public void test4() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("q")).sendKeys("Hello,world");
	    driver.findElement(By.id("search__button__wrapper__field")).click();
  }
/*
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }*/
}

