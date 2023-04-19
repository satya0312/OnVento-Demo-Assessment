package com.ui.test.selenium.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	private DateUtil() {

	}

	public static String getTime(String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.getDefault());
		return simpleDateFormat.format(new Date().getTime());
	}
}
