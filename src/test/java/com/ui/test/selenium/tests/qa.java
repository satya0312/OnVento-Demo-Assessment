package com.ui.test.selenium.tests;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class qa {

	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("HH-MM-SS", Locale.getDefault());
		System.out.println(format.format(new Date().getTime()));

	}

}
