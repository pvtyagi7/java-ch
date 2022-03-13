package multiThreadingExamples;

public class DatabaseToFileUsingThread implements Runnable {
	
	public void run() {
		
	}
	public static void main(String[] args) {
		Thread thread1 = new Thread(new DatabaseToFileUsingThread());
		Thread thread2 = new Thread(new DatabaseToFileUsingThread());
		thread1.start();
		thread2.start();
	}

}
