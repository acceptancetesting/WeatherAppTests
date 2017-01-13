# WeatherAppTests<br />
WeatherApp selenium cucumber java test<br />

Draft version of BDD test<br />
Language/Packages used: Java, Selenium, Webdriver, Cucumber<br />
Build tool: Maven<br />

Test Approach:<br />
  Business level sample tests defined (Happy Path)<br />
  Negative/Edge cases not defined due to 2-4 hour time constraint<br />
  Static test data as json files mapped to Java Objects to check UI validation<br />
  
Assumptions/Limitations:<br />
  App will be up and running<br />
  Limited knowledge and time constraint for learning Node.js and corresponding testing framework<br />
  Review has knowlegde of Java/Selenium based framework<br />
  
Techanical Stuff:<br />
  Build tool used is Maven<br />
  Folder Structure:<br />
    src/main/java -
      pageObjects - One page object created for one page (index page)
      responseMapper - JSON response mapper using Jackson 2.0 (Creates Java object for easier access to response)
    
    src/test/java 
      weatherAppTestData - Sample JSON files
      weatherAppTestRunner - Runner file (Can be used to filter tests) and used for running cucumber tests.
                           - Steps file defining all the test steps
    
    src/test/resources
      config.properties - Draft properties file defining BASE_URL,PORT etc. Can be used for env 
      happyPathScenarios - High level cucumber tests accessing webapp and checking its behaviour
      
    pom.xml <br />
      defining all dependencies<br />
      

To run test - run the RunnerTest.java or build install the soln<br />

Remaining Tasks not achieved due time constraints<br />
  Negative Tests<br />
  Edge cases<br />
  Proper validation on each step definition<br />
  Would be better to use same language/framework as code was developed in<br />
  
  
             
  
 
