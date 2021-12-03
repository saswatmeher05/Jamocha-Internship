package com.executor.customexecurorservice;

public class MyExecutors {
	int capacity;
	public static MyExecutorService myNewFixedSizeThreadPool(int capacity) {
		return new MyThreadPool(capacity);
	} 
}
