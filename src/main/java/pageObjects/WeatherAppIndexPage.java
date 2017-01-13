package pageObjects;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class WeatherAppIndexPage {

	    WebDriver driver;
	    
	    public WeatherAppIndexPage(WebDriver driver){ 			//Constructor
	        this.driver = driver;
	    }
	    
	    
	    public void waitForLoad() { 							//Load for page to load completely
	        new WebDriverWait(this.driver, 30).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
	    }
	    	
	    
	    public boolean loadWeatherApp() {						//Load config files and load we app in chrome browser
	    	Properties prop = new Properties();
	    	InputStream input = null;
	    	try {
	    		prop = new Properties();
				input = new FileInputStream("src/test/resource/config.properties");
				prop.load(input);
				driver.get(prop.getProperty("BASE_URL")+":"+prop.getProperty("PORT"));
				return true;
			} catch (IOException ex) {
				ex.printStackTrace();
				return false;
			} finally {
				if (input != null) {
					try {
						input.close();
						return true;
					} catch (IOException e) {
						e.printStackTrace();
						return false;
					}
				}
			}
	    }

	    public void expandDay(int day){							//Page functionality expand day
	         // driver.findElement(login).click();
	    }

	    public void collapseDay(int day){						//Page functionality collapse day
            //	driver.findElement(login).click();
	    }
	    														//Get the title of Index Page
	    public String getTitle(){
	     return    driver.getTitle();
	    }

}
