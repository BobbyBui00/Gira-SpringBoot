package cybersoft.javabackend.java11.gira.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	
	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
	
	// Parsing from Json dateTime to string
	public static String toString(LocalDateTime date) {
		return date.format(formatter);
	}
	
	// Parsing from string dateTime to Json dateTime
	public static LocalDateTime toDate(String date) {
		return LocalDateTime.parse(date, formatter);
	}
}
