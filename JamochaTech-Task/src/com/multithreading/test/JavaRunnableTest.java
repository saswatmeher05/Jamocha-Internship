package com.multithreading.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class JavaRunnableTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException, ParseException {
		Timer timer=new Timer();
		Date date=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse("02-12-2021 16:56:10");
		timer.schedule(new MyTimerSchedule(timer), date);
	}

}
