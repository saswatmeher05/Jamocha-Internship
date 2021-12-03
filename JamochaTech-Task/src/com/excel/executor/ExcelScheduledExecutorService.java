package com.excel.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExcelScheduledExecutorService {
	
	private static ExcelScheduledExecutorService eses = new ExcelScheduledExecutorService();
	private ExecutorService service;
	private LinkedBlockingQueue<Runnable> lbq;

	private ExcelScheduledExecutorService() {
		lbq = new LinkedBlockingQueue<Runnable>();
		service = new ThreadPoolExecutor(4, 8, 3, TimeUnit.SECONDS, lbq);
	}

	public void submitToThreadPool(Callable<Boolean> callable) {
		service.submit(callable);
	}

	public static ExcelScheduledExecutorService getInstance() {
		return eses;
	}

	public ExecutorService getExecutorService() {
		return service;
	}
}
