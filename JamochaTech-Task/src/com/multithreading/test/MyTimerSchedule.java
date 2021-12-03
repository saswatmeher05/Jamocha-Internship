package com.multithreading.test;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;

import com.thread.test.ExcelFileFilter;

public class MyTimerSchedule extends TimerTask {
	Timer timer;
	
	public MyTimerSchedule(Timer timer) {
		this.timer=timer;
	}

	@Override
	public void run() {
		try {
		ExcelFileFilter filter = new ExcelFileFilter();
		File dir = new File("C:\\Users\\saswa\\Documents");
		File files[] = dir.listFiles(filter);
//		System.out.println(files.length);
//		ScheduledExecutorService ses = Executors.newScheduledThreadPool(5);
		ExecutorService ses = new MyCustomExecutorService();
		for (int i = 0; i < files.length; i++) {
//			Future<Boolean> sf = 
			ses.submit(new JavaCallable(files[i]));
//			sf.get();
		}
		ses.shutdown();
		timer.cancel();
		}catch(Exception e) {e.printStackTrace();}
	}

}
