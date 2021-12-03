package com.excel.executor;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.Callable;
import com.thread.test.PrintXlsxFile;

public class MyExcelFileExecutorCallable implements Callable<Boolean> {

	public File file;
	
	public MyExcelFileExecutorCallable(File file) {
		this.file = file;
	}
	
	@Override
	public Boolean call() throws Exception {
		FileInputStream fis=new FileInputStream(file);
		PrintXlsxFile.printExcelFile(fis);
		return true;
	}
}
