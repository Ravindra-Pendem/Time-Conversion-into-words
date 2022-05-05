package com.wisdomeleaf.TimeConvertion.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class TimeConvertionServiceImpl implements TimeConvertionService {

	@Override
	public String getTime() {

		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
		String strTime = dateFormat.format(date);
		String sTime = dateFormat.format(date).toString();
		String sHours = sTime.substring(0, 2);
		String sMinutes = sTime.substring(3, 5);
		String sMarker = sTime.substring(6);

		String time_name = "";

		try {

			int hours = Integer.parseInt(sHours);
			int minutes = Integer.parseInt(sMinutes);

			if ((hours >= 1 && hours <= 12) && (minutes >= 0 && minutes <= 59)) {

				String hour_mint[] = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
						"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
						"Eighteen", "Nineteen", "Twenty", "Twenty one", "Twenty two", "Twenty three", "Twenty four",
						"Twenty five", "Twenty six", "Twenty seven", "Twenty eight", "Twenty nine" };

				String a;
				
				if (hours == 12)
					a = hour_mint[1];// put 'one' if hour is 12
				else
					a = hour_mint[hours + 1]; // if hour is not 12 then store an hour ahead of given hour

				if (minutes == 0) {
					time_name = hour_mint[hours] + " o'clock";
					if(hours == 12) {
						if(sMarker == "am") {
							time_name = time_name + "\nIt's Midnight";
						}
						else {
							time_name = time_name + "\nIt's Midday";
						}	
					}
					}
				else if (minutes == 15)
					time_name = "Quarter past " + hour_mint[hours];
				else if (minutes == 30)
					time_name = "Quarter past " + hour_mint[hours];
				else if (minutes == 45)
					time_name = "Quarter to " + a;
				else if (minutes < 30) // for minutes between 1-29
					time_name = hour_mint[minutes] + " past " + hour_mint[hours];
				else // between 31-59
					time_name = hour_mint[60 - minutes] + " to " + a;

			} else
				time_name = "invalid time format";

		}

		catch (NumberFormatException e) {
			System.out.println("invalid input");
		}

		System.out.println("It's "+ time_name);
		return time_name; 
	}

}
