package responseMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HourlyDetailGenerator {	//Create object with hourly class
	public static ArrayList<HourlyDetails> citySummary(Example ex){
		ArrayList<HourlyDetails> dateSummaryList = new ArrayList();	//Hourly list with all details for that hour
		java.util.List<List> allList = ex.getList();
		java.util.List<String> dates = new ArrayList();
		java.util.List<String> dateandtime = new ArrayList();
		HourlyDetails hourly = new HourlyDetails();
		int counter=0;
		int dayNo=1;
		for (List elements : allList) {
			dates.add(elements.getDtTxt());
			dateandtime.add(elements.getDtTxt());
		}
		
		for (String daySummary : dateandtime) {						//Iterate through all dates and add to return list		
			HourlyDetails summary = new HourlyDetails();
			if (daySummary.equals(allList.get(counter).getDtTxt())) {
					summary.setDay(allList.get(counter).getDtTxt().substring(0, 10));		//Get just date
					summary.setHour(allList.get(counter).getDtTxt().substring(11,16));		//Get just time
					summary.setMaxTemp(allList.get(counter).getMain().getTempMax());			
					summary.setMinTemp(allList.get(counter).getMain().getTempMin());	
					//TODO : Pending set all elements
				}
			counter = counter + 1;
			dateSummaryList.add(summary);
		}
		return dateSummaryList;
}
}
