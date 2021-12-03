package com.thread.test;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class MyCallableTestNew {
	public static synchronized void main(String[] args) throws InterruptedException {
		System.out.println("--------------------------------------------------------------");
		try {
			// Getting only excel files from dir by filtering
			ExcelFileFilter filter = new ExcelFileFilter();
			File dir = new File("C:\\Users\\saswa\\Documents");
			File files[] = dir.listFiles(filter);
			
			// Creating some future tasks
			FutureTask tasks[] = new FutureTask[files.length];
			for (int i = 0; i < files.length; i++) {
				Callable callable = new MyCallable(files[i]);
				tasks[i] = new FutureTask(callable);
				
				//creating thread
				Thread thread = new Thread(tasks[i]);
				thread.setName("Thread " + i);
				thread.start();
			}
			
			for (int i = 0; i < tasks.length; i++) {
				tasks[i].get();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
