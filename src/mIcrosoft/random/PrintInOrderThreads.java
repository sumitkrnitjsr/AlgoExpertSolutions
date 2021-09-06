package mIcrosoft.random;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

// this.notifyAll(); should be called from inside of synchronized block

public class PrintInOrderThreads {
	
	 int flag = 0;
	    
	    public PrintInOrderThreads() {
	        flag = 1;
	    }

	    public void first(Runnable printFirst) throws InterruptedException {
	        
	        // printFirst.run() outputs "first". Do not change or remove this line.
	        synchronized(this) {
	            while(flag < 1) {
	                try{
	                    this.wait();
	                }catch(Exception ex) {
	                    
	                }
	            }
	        printFirst.run();
	        flag++;
	        this.notifyAll();
	    }
	    }

	    public void second(Runnable printSecond) throws InterruptedException {
	        
	        // printSecond.run() outputs "second". Do not change or remove this line.
	         synchronized(this) {
	            while(flag < 2) {
	                try{
	                    this.wait();
	                }catch(Exception ex) {
	                    
	                }
	            }
	        printSecond.run();
	        flag++;
	        this.notifyAll();
	    }
	    }

	    public void third(Runnable printThird) throws InterruptedException {
	        
	        // printThird.run() outputs "third". Do not change or remove this line.
	        synchronized(this) {
	            while(flag < 3) {
	                try{
	                    this.wait();
	                }catch(Exception ex) {
	                    
	                }
	            }
	        printThird.run();
	        flag++;
	        this.notifyAll();
	    }
	    }
	    
	    
	    
	    class FooAtomicInteger {

	    	  private AtomicInteger firstJobDone = new AtomicInteger(0);
	    	  private AtomicInteger secondJobDone = new AtomicInteger(0);

	    	  public FooAtomicInteger() {}

	    	  public void first(Runnable printFirst) throws InterruptedException {
	    	    // printFirst.run() outputs "first".
	    	    printFirst.run();
	    	    // mark the first job as done, by increasing its count.
	    	    firstJobDone.incrementAndGet();
	    	  }

	    	  public void second(Runnable printSecond) throws InterruptedException {
	    	    while (firstJobDone.get() != 1) {
	    	      // waiting for the first job to be done.
	    	    }
	    	    // printSecond.run() outputs "second".
	    	    printSecond.run();
	    	    // mark the second as done, by increasing its count.
	    	    secondJobDone.incrementAndGet();
	    	  }

	    	  public void third(Runnable printThird) throws InterruptedException {
	    	    while (secondJobDone.get() != 1) {
	    	      // waiting for the second job to be done.
	    	    }
	    	    // printThird.run() outputs "third".
	    	    printThird.run();
	    	  }
	    	}


class FooSemaphore {

    private Semaphore[] semaphore;
    
    public FooSemaphore() {
        int numOfThreads = 3;
        semaphore = new Semaphore[numOfThreads];
        
        try {
            for (int i = 0 ; i< numOfThreads; ++i) {
                // Binary semaphore, since there is only one resource i.e., "Print N".
                semaphore[i] = new Semaphore(1, true);
                
                // Don't let any thread print.
                semaphore[i].acquire();
            }

            // Let a thread to print "first".
            semaphore[0].release();
        } catch (InterruptedException ie) {
            // NO-OP.
        }
    }

    public void first(Runnable printFirst) throws InterruptedException {
        semaphore[0].acquire();
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        
        semaphore[1].release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore[1].acquire();
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        
        semaphore[2].release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore[2].acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        
        semaphore[0].release();
    }
}
	    
	    

}
