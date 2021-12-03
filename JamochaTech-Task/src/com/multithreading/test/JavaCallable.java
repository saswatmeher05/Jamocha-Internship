package com.multithreading.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import com.thread.test.PrintXlsxFile;

public class JavaCallable implements Callable<Boolean> {
	public File file;

	public JavaCallable(File file) {
		this.file = file;
	}

	@Override
	public  Boolean call() {
		try {
//			System.out.println("----" + Thread.currentThread().getName() + "-------------------------------------------");
			FileInputStream fis = new FileInputStream(this.file);
			PrintXlsxFile.printExcelFile(fis);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
