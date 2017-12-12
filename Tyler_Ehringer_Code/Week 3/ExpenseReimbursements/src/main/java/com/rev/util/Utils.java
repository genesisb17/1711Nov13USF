package com.rev.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;

public class Utils {
	
	public static String getJson(ServletInputStream in) {
		return (new BufferedReader(new InputStreamReader(in))).lines().reduce("", (a, b) -> a + b);
	}
	
}
