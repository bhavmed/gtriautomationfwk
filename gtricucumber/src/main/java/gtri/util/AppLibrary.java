package gtri.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class AppLibrary {
	
	public static String generateFutureDate(int noofDays,String format)
	{

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, noofDays);
		Date d = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String formattedDate = sdf.format(d);
		System.out.println("Formatted Date   " + formattedDate);
		return formattedDate;
	}
	public static String convertDateFormat(Date d , String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String formattedDate = sdf.format(d);
		System.out.println("Formatted Date   " + formattedDate);
		return formattedDate;
	}
	public static String randomStringValue(String sValue)
	{
		Random rand= new Random();
		int i =65 + rand.nextInt(26);
		char ch = (char)i;
		return sValue+ch;
	}
	 
}
