package com.foundation.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDatePractice {
	public static void main(String[] args) {
		LocalDate timeNow = LocalDate.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		
		System.out.println(timeNow);
		System.out.println(localDateTime);
		
		String formattedDate = localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
		System.out.println(formattedDate);
	}
}
