package com.prep.Algorithms.threading;

import java.lang.management.ManagementFactory;

public class DeadlockImpl {

	public static void main(String[] args) throws InterruptedException {
		String s1 = "abc";
		String s2 = "xyz";
		System.out.println("Proc id: "+ ManagementFactory.getRuntimeMXBean().getName());
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized(s1) {
					System.out.println("Inside T1, locked s1");
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					synchronized(s2) {
						System.out.println("Inside T1, locked s2");
					}
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized(s1) {
					System.out.println("Inside T2, locked s2");
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					synchronized(s2) {
						System.out.println("Inside T2, locked s1");
					}
				}
			}
		});
		
		t1.start();
		t2.start();
		
		System.out.println("In main thread, started both threads");
		t1.join();
		t2.join();
		System.out.println("Completed both thread run");
	}
}
