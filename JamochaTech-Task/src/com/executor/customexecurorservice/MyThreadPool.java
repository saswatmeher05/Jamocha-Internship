package com.executor.customexecurorservice;

import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool implements MyExecutorService {
	public static int capacity;
	public static int currentCapacity;
	public static LinkedBlockingQueue<Runnable> linkedTaskBlockingQueue;
	public Execution e;

	public MyThreadPool(int capacity) {
		this.capacity = capacity;
		currentCapacity = 0;
		linkedTaskBlockingQueue = new LinkedBlockingQueue<Runnable>();
		e = new Execution();
	}

	@Override
	public void submit(Runnable r) {
		linkedTaskBlockingQueue.add(r);
		e.executeMyMethod();
	}

}
