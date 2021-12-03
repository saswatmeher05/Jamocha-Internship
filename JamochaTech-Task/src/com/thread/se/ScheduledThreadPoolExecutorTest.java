package com.thread.se;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.thread.test.ExcelFileFilter;

public class ScheduledThreadPoolExecutorTest {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date=format.parse("02-12-2021 18:27:20");
		ExcelFileFilter filter=new ExcelFileFilter();
		File dir=new File("C:\\Users\\saswa\\Documents");
		File file[]=dir.listFiles(filter);
		Runnable runnable[]=new Runnable[file.length];
		ScheduledThreadPoolExecutor stpe=new ScheduledThreadPoolExecutor(file.length);
		for(int i=0;i<file.length;i++) {
			runnable[i]=new MyRunnable(file[i]);
		}
		for(int i=0;i<runnable.length;i++) {
			stpe.schedule(runnable[i], date.getTime()-new Date().getTime() , TimeUnit.MILLISECONDS);
		}
		stpe.shutdown();

	}

}
