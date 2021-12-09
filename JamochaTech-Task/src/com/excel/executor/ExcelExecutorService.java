package com.excel.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExcelExecutorService {
	
	private static ExcelExecutorService eses = new ExcelExecutorService();
	private ExecutorService service;
	private LinkedBlockingQueue<Runnable> lbq;

	private ExcelExecutorService() {
		lbq = new LinkedBlockingQueue<Runnable>();
		service = new ThreadPoolExecutor(4, 8, 3, TimeUnit.SECONDS, lbq);
	}

	public void submitToThreadPool(Callable<Boolean> callable) {
		service.submit(callable);
	}

	public static ExcelExecutorService getInstance() {
		return eses;
	}

	public ExecutorService getExecutorService() {
		return service;
	}
}
