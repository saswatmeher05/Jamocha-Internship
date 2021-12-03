package com.thread.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.Callable;

@SuppressWarnings("rawtypes")
public class MyCallable implements Callable {
	public File file;

	public MyCallable(File file) {
		this.file = file;
	}

	@Override
	public String call() throws Exception {
		try{
			PrintXlsxFile.printExcelFile(new FileInputStream(this.file));			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Completed";
	}
}
