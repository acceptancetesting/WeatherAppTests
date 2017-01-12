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

	public class Steps {
		
		protected WebDriver driver;
		WeatherAppIndexPage webApp;
		Example jsonResponseObject;
		String elementid;
		SummaryGenerator summary = new SummaryGenerator();
		HourlyDetailGenerator hourly = new HourlyDetailGenerator();
		@Before
	    public void setup() {
	        driver = new ChromeDriver();
	        webApp = new WeatherAppIndexPage(driver);
	}
		
		
		@Given("^weather app is available$")
		public void weather_app_is_available() {
			Assert.assertTrue(webApp.loadWeatherApp());
		}

		@Given("^I request weather forecast for (.*)$")
		public void i_request_weather_forecast_for_city(String cityName)  {
			jsonResponseObject = JsonResponse.getJsonResponse(cityName);
		}

		@When("^I submit the request$")
		public void i_submit_the_request()  {
			webApp.waitForLoad();
			
		}
		
		@Then("^I should get forecast for next (\\d+) days$")
		public void i_should_get_forecast_for_next_days(int noOfDays)  {
		    if (noOfDays <= summary.citySummary(jsonResponseObject).size()) { //
		    	for (int i=1;i<=noOfDays;i=i+1) {
		    		elementid = "span[data-test='date-" + i + "']";
		    		Assert.assertEquals(summary.citySummary(jsonResponseObject).get(i-1).getDate().substring(8), driver.findElement(By.cssSelector(elementid)).getText());
		    	}
		    }
			else {
				Assert.fail();
			}
		}
		
		@Then("^each days forecast should have (.*)$")
		public void each_days_forecast_should_have(String component)  {
					if (component.equals("description")) {
						 elementid = "svg[data-test='"+ component + "-1']";
					} 
					else {
						 elementid = "span[data-test='"+ component + "-1']";
					}
		    Assert.assertTrue(driver.findElement(By.cssSelector(elementid)).isDisplayed());
		}
		
		@When("^I click and expand the day summary$")
		public void i_click_and_expand_the_day_summary()  {
			for(int i = 1;	i<=5;	i++) {
				elementid = "span[data-test='date-" + i + "']";
				String childelementid = "span[data-test='hour-" + i + "-1']";
				driver.findElement(By.cssSelector(elementid)).click();
				webApp.waitForLoad();
				Assert.assertTrue(driver.findElement(By.cssSelector(childelementid)).isDisplayed());
			}
			
		}
		
		@Then("^correct three hourly details should be displayed for as in app response$")
		public void correct_three_hourly_details_should_be_displayed()  {
			 for (HourlyDetails elements : hourly.citySummary(jsonResponseObject)) {
				 //System.out.println(elements.getDay() + "-" + elements.getHour());
			}
			
		}
		
		 @After
		    public void closeBrowser() {
		        driver.quit();
		 }
	}