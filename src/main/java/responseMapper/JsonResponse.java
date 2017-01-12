package responseMapper;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;


public class JsonResponse {
	public static void main(String args[]){
		ObjectMapper objectmapper = new ObjectMapper(); // can reuse, share globally
		String filePath = new File("").getAbsolutePath();
		System.out.println(filePath);
		File file = new File(filePath+"/src/test/java/WeatherAppTestData/"+"aberdeen.json");
		
		try
		{
		Example inputJson = objectmapper.readValue(file,Example.class);
		for (List d: inputJson.getList()) {
			System.out.println(d.getDtTxt());
		}
		}
	      catch (JsonParseException e1) { e1.printStackTrace();}
	      catch (JsonMappingException e2) { e2.printStackTrace(); }
	      catch (IOException e3) { e3.printStackTrace(); }
	   }
	
	
	public static Example getJsonResponse(String cityName){
		ObjectMapper objectmapper = new ObjectMapper(); // can reuse, share globally
		Example inputJson = new Example();
		String filePath = new File("").getAbsolutePath();
		//System.out.println(filePath);
		File file = new File(filePath+"/src/test/java/weatherAppTestData/"+cityName.toLowerCase()+".json");
		
		try
		{
			inputJson = objectmapper.readValue(file,Example.class);
		}
	      catch (JsonParseException e1) { e1.printStackTrace(); }
	      catch (JsonMappingException e2) { e2.printStackTrace(); }
	      catch (IOException e3) { e3.printStackTrace(); }
		return inputJson;
	   }
}