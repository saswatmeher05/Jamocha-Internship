package com.thread.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

@SuppressWarnings({"rawtypes","unchecked"})
public class MyCallableTestNew {
	public static void main(String[] args) {
		Callable callable=new MyCallable();
		FutureTask task=new FutureTask(callable);
		Thread thread=new Thread(task);
		thread.start();
		System.out.println("---------------------------------------------------------------------------");
		try {
			File files[]=(File[])task.get();
			for(File file:files) {
				FileInputStream fis=new FileInputStream(file);
				PrintXlsxFile.printExcelFile(fis);
				Thread.sleep(1000);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
