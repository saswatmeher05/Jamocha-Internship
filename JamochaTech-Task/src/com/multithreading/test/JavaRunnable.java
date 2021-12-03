package com.multithreading.test;

import java.io.File;
import java.io.FileInputStream;

import com.thread.test.PrintXlsxFile;

public class JavaRunnable implements Runnable {
	public File file;
	
	public JavaRunnable(File file) {
		this.file=file;
	}
	
	@Override
	public synchronized void run() {
		try {
			Thread.sleep(4000);
			System.out.println("----" + Thread.currentThread().getName() + "-------------------------------------------");
			FileInputStream fis = new FileInputStream(this.file);
			PrintXlsxFile.printExcelFile(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
