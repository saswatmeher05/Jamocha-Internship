package com.executor.customexecurorservice;

public class Execution implements Runnable {

	@Override
	public void run() {
		while(true) {
			if(MyThreadPool.linkedTaskBlockingQueue.size()!=0) {
				MyThreadPool.linkedTaskBlockingQueue.poll().run();
			}
		}

	}
	
	public void executeMyMethod() {
		if(MyThreadPool.currentCapacity<MyThreadPool.capacity) {
			MyThreadPool.currentCapacity++;
			Thread t=new Thread(new Execution());
			t.start();
		}
	}

}
