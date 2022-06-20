package com.prep.Algorithms.threading;

public class ProducerConsumerImpl {
	
	static String shared = "";
	public static void main(String args[]) {
		
		
		Thread producerThread = new Thread(new Runnable() {
			int count = 1;
			
			@Override
			public void run() {
				synchronized(shared) {
					while(shared == null) {
						try {
							wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					shared = "count " + count++;
					notifyAll();
				}
			}
		});
		
		Thread consumerThread = new Thread(new Runnable() {
			String shared = "";
			
			@Override
			public void run() {
				while(shared != null) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
	}
}
