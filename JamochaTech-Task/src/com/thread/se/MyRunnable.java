package com.thread.se;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.thread.test.PrintXlsxFile;

public class MyRunnable implements Runnable {
	File file;
	
	MyRunnable(File file){
		this.file=file;
	}

	@Override
	public void run() {
		
		try {
			FileInputStream fis=new FileInputStream(file);
			PrintXlsxFile.printExcelFile(fis);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
