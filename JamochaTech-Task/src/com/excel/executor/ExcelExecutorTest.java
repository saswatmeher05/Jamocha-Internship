package com.excel.executor;

import java.io.File;
import com.thread.test.ExcelFileFilter;

public class ExcelExecutorTest {

	public static void main(String[] args) throws ClassNotFoundException {
		ExcelFileFilter filter=new ExcelFileFilter();
		File dir=new File("C:\\Users\\saswa\\Documents");
		File file[]=dir.listFiles(filter);
		
		ExcelExecutorService eses=ExcelExecutorService.getInstance();
		
		for(int i=0;i<file.length;i++) {
			eses.submitToThreadPool(new MyExcelCallable(file[i]));
		}
		
		eses.getExecutorService().shutdown();
	}
}
