package com.prep.Algorithms.threading;

public class ThreadVsRunnableTest {

	public static void main(String[] args) throws InterruptedException {
		startRegularThreads();
		//startRunnerThreads();
		

		System.out.println("Main thread exiting");
		
	}
	
	public static void startRunnerThreads() throws InterruptedException {
		ImplementRunnable implementRunnable1 = new ImplementRunnable();
		ImplementRunnable implementRunnable2 = new ImplementRunnable();
		Thread t3 = new Thread(implementRunnable1, "Thread-3");
		//Thread t4 = new Thread(implementRunnable2, "Thread-4");
		Thread t4 = new Thread(implementRunnable1, "Thread-4");
		
		t3.start();
		t4.start();
		t3.join();
		t4.join();
	}
	
	public static void startRegularThreads() throws InterruptedException {
		ExtendThread extendThread1 = new ExtendThread();
		ExtendThread extendThread2 = new ExtendThread();
		Thread t1 = new Thread(extendThread1, "Thread-1");
		Thread t2 = new Thread(extendThread1, "Thread-2");
		
		extendThread1.start();
		extendThread2.start();
		
		//extendThread1.join();
		//extendThread2.join();
	}
}

class ExtendThread extends Thread {
	
	@Override
	public void run() {
		System.out.println("Thread running in ExtendThread ..." + Thread.currentThread().getName());
	}
}

class ImplementRunnable implements Runnable {
	
	@Override
	public void run() {
		System.out.println("Thread running in ImplementRunnable ... " + Thread.currentThread().getName());
	}
}
