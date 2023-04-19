package com.ui.test.selenium.utils;

import java.util.Random;

public class RandomUtil {
	private RandomUtil() {

	}

	public static int getRandomNumber() {
		return new Random().nextInt(900000) + 100000;
	}
}
