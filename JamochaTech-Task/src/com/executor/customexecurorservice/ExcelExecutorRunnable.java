package com.executor.customexecurorservice;

import java.io.File;
import java.io.FileInputStream;

import com.thread.test.PrintXlsxFile;

public class ExcelExecutorRunnable implements Runnable{
	public File file;
	public ExcelExecutorRunnable(File file) {
		this.file=file;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			FileInputStream fis=new FileInputStream(file);
			PrintXlsxFile.printExcelFile(fis);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
