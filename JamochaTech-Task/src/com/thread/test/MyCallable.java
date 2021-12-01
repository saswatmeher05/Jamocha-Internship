package com.thread.test;

import java.io.File;
import java.util.concurrent.Callable;

@SuppressWarnings("rawtypes")
public class MyCallable implements Callable {
	@Override
	public File[] call() throws Exception {
		// read file date(bytes)
		ExcelFileFilter filter=new ExcelFileFilter();
		File dir=new File("C:\\Users\\saswa\\Documents");
		File files[]=dir.listFiles(filter);
//		FileInputStream fis = new FileInputStream(new File("D:\\Downloads\\Documents\\file_example1.xlsx"));
		return files;
	}
}
