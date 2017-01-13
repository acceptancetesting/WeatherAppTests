package weatherAppTestRunner;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.WeatherAppIndexPage;
import responseMapper.Example;
import responseMapper.HourlyDetailGenerator;
import responseMapper.HourlyDetails;
import responseMapper.JsonResponse;
import responseMapper.SummaryDetails;
import responseMapper.SummaryGenerator;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

	public class Steps {			//Step definitions for feature files
		
		protected WebDriver driver;		//create driver object to handle web app 
		WeatherAppIndexPage webApp;		
		Example jsonResponseObject;		//JSON request mapper
		String elementid;				//variable to create required element identifier
		SummaryGenerator summary = new SummaryGenerator();		//variable for daily summary
		HourlyDetailGenerator hourly = new HourlyDetailGenerator();	//variable for hourly summary
		@Before							//Junit annotation to set up before test run
	    public void setup() {
	        driver = new ChromeDriver();		//Chrome driver used for draft version
	        webApp = new WeatherAppIndexPage(driver);
	}
		
		
		@Given("^weather app is available$")
		public void weather_app_is_available() {			//Load weather app in chrome driver 
			Assert.assertTrue(webApp.loadWeatherApp());		//Check weather app is loaded and ready for further tests
		}

		@Given("^I request weather forecast for (.*)$")
		public void i_request_weather_forecast_for_city(String cityName)  {
			jsonResponseObject = JsonResponse.getJsonResponse(cityName);		//Load request and map to object for that particular city
		}

		@When("^I submit the request$")
		public void i_submit_the_request()  {
			webApp.waitForLoad();			//As there is no request submission just dummy wait for page to load
			
		}
		
		@Then("^I should get forecast for next (\\d+) days$")
		public void i_should_get_forecast_for_next_days(int noOfDays)  {
		    if (noOfDays <= summary.citySummary(jsonResponseObject).size()) { //Check request and response has same no of days returned
		    	for (int i=1;i<=noOfDays;i=i+1) {
		    		elementid = "span[data-test='date-" + i + "']";			//Create variable to identify which element
		    		Assert.assertEquals(summary.citySummary(jsonResponseObject).get(i-1).getDate().substring(8), driver.findElement(By.cssSelector(elementid)).getText()); //Check if date shown on UI and request is same
		    	}
		    }
			else {
				Assert.fail(); //Sample fail if request and response has different dates 
			}
		}
		
		@Then("^each days forecast should have (.*)$")
		public void each_days_forecast_should_have(String component)  {
					if (component.equals("description")) {		//Different tag for description SVG
						 elementid = "svg[data-test='"+ component + "-1']";	
					} 
					else {
						 elementid = "span[data-test='"+ component + "-1']";
					}
		    Assert.assertTrue(driver.findElement(By.cssSelector(elementid)).isDisplayed());	//Check all mandatory elements are displayed
		}
		
		@When("^I click and expand the day summary$")
		public void i_click_and_expand_the_day_summary()  {
			for(int i = 1;	i<=5;	i++) {					//Hard coded to 5 at the moment as number of days to expand
				elementid = "span[data-test='date-" + i + "']";
				String childelementid = "span[data-test='hour-" + i + "-1']";
				driver.findElement(By.cssSelector(elementid)).click();
				webApp.waitForLoad();
				Assert.assertTrue(driver.findElement(By.cssSelector(childelementid)).isDisplayed()); //Check first child element is visible and can be expanded to all elements of expanded rows
			}
			
		}
		
		@Then("^correct three hourly details should be displayed for as in app response$")
		public void correct_three_hourly_details_should_be_displayed()  {
			 for (HourlyDetails elements : hourly.citySummary(jsonResponseObject)) {
				 //System.out.println(elements.getDay() + "-" + elements.getHour()); 
				 //TODO - Pending implementations
			}
			
		}
		
		 @After
		    public void closeBrowser() {	//Junit after annotation to close browser
		        driver.quit();
		 }
	}