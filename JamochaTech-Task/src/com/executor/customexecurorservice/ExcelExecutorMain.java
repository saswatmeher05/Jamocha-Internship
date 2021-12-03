package com.executor.customexecurorservice;

import java.io.File;

import com.thread.test.ExcelFileFilter;

public class ExcelExecutorMain {

	public static void main(String[] args) {
		ExcelFileFilter filter=new ExcelFileFilter();
		File dir=new File("C:\\Users\\saswa\\Documents");
		File file[]=dir.listFiles(filter);
		MyExecutorService service=MyExecutors.myNewFixedSizeThreadPool(1);
		int i=0;
		for(i=0;i<file.length;i++) {
			service.submit(new ExcelExecutorRunnable(file[i]));
		}
	}

}
