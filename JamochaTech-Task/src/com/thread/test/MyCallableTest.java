package com.thread.test;

import java.io.FileInputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class MyCallableTest {

	public static void main(String[] args) {
		// create some FutureTask object
		FutureTask[] ft = new FutureTask[3];

		for (int i = 0; i < ft.length; i++) {
			// create MyCallable object
//			Callable callable = new MyCallable();
			// create new FutureTask with MyCallable object
//			ft[i] = new FutureTask(callable);
			Thread thread = new Thread(ft[i]);
			thread.start();
		}
		
		System.out.println("--------------------------------------------------------------");
		// using get() method to get data
		for (int i = 0; i < ft.length; i++) {
			try {
				FileInputStream fis = (FileInputStream) ft[i].get();
				PrintXlsxFile.printExcelFile(fis);
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
