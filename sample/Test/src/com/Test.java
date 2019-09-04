package com;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		System.out.println(sdf.format(new Date(1561554154352L)));
		System.out.println('A' + 32);
		System.out.println(vowelOnly("Hello World!"));
	}
	
	public static String vowelOnly(String input) {
		return input.replaceAll("[^(a|A|e|E|i|I|o|O|u|U)]", ""); 
	}

}
