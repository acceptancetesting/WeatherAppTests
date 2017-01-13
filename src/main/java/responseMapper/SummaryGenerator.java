package responseMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SummaryGenerator {			//
	public static ArrayList<SummaryDetails> citySummary(Example ex){		//Function to generate daily summary details
		ArrayList<SummaryDetails> dateSummaryList = new ArrayList();
		java.util.List<List> allList = ex.getList();
		java.util.List<String> dates = new ArrayList();
		java.util.List<String> dateandtime = new ArrayList();
		for (List elements : allList) {
			dates.add(elements.getDtTxt().substring(0,10));		//Create date only list
			dateandtime.add(elements.getDtTxt());				//Create date with 3 hour time list
		}
		
		Set<String> uniqueDates = new HashSet<>();			//Get Unique dates 
		uniqueDates.addAll(dates);
		dates.clear();
		dates.addAll(uniqueDates);
		
		//System.out.println(dates.toString());
		
		for (String daySummary : dates) {					//Iterate through dates to create summary rows
			SummaryDetails summary = new SummaryDetails();
			for (List elements : allList) {
				if (daySummary.equals(elements.getDtTxt().substring(0, 10))) {
					if (summary.getDate()==null) {
						summary.setDate(daySummary);
					}
					if (summary.getMaxTemp()==null || summary.getMaxTemp()<elements.getMain().getTemp()) {
						summary.setMaxTemp(elements.getMain().getTemp());
					}
					
					if (summary.getMinTemp()==null || summary.getMinTemp()>elements.getMain().getTemp()) {
						summary.setMinTemp(elements.getMain().getTemp());
					}
					
					if (summary.getWindSpeed()==null || summary.getWindSpeed()<elements.getWind().getSpeed()) {
						summary.setWindSpeed(elements.getWind().getSpeed());
					}
					
					if (summary.getRain()==null || summary.getRain()<elements.getRain().get3h()){
						summary.setWindSpeed(elements.getRain().get3h());
					}
					
				}
			}
			
			dateSummaryList.add(summary);
		}
		return dateSummaryList;
}
}
