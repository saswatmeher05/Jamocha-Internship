package com.thread.test;

import java.io.File;
import java.io.FileFilter;

public class ExcelFileFilter implements FileFilter{
	@Override
	public boolean accept(File file) {
		return file!=null && file.isFile() && file.canRead() && file.getName().endsWith(".xlsx");
	}
}
