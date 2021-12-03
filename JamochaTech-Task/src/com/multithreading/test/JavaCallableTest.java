package com.multithreading.test;

import java.io.File;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


import com.thread.test.ExcelFileFilter;

public class JavaCallableTest {
	public static void main(String[] args) {
		try {
//			Scanner sc = new Scanner(System.in);
//			System.out.println("Schedule Task(HH:M)-24H format:");
//			System.out.println("Enter Hour:");
//			int hour = Integer.parseInt(sc.nextLine());
//			System.out.println("Enter Minutes:");
//			int min = Integer.parseInt(sc.nextLine());
			ExcelFileFilter filter = new ExcelFileFilter();
			File dir = new File("C:\\Users\\saswa\\Documents");
			File[] files = dir.listFiles(filter);
			ScheduledExecutorService ses = Executors.newScheduledThreadPool(5);
//			boolean flag = false;
			for (int i = 0; i < files.length; i++) {
				
				ScheduledFuture<Boolean> sf = ses.schedule(new JavaCallable(files[i]), 2, TimeUnit.SECONDS);
				sf.get();
			}
			ses.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}









//FutureTask<String> tasks[]=new FutureTask[files.length];
//Callable<String> callable=new JavaCallable(files[i]);
//tasks[i]=new FutureTask<String>(callable);
//Thread thread=new Thread(tasks[i]);
//thread.setName(files[i].getName());
//thread.start();
//thread.join();
//for(int i=0;i<tasks.length-1;i++) {
//s=tasks[i].get();
//}
//System.out.println(s+" All Files");
