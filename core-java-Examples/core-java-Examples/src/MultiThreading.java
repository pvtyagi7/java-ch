
class MyThread extends Thread {
	public void run() {
		// for(int i=0; i<5; i++)
		System.out.println(Thread.currentThread().getName());
	}
}

public class MultiThreading {
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();
		t1.start();
		t2.start();
		t3.start();
		System.out.println("Thread started..");

	}
}