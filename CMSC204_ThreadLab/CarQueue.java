import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

/**
 * 
 * @author Elizabeth Perez
 *
 */

public class CarQueue {
	Queue<Integer> queue;
	Random rand;
	
	public CarQueue() {
		queue = new ArrayDeque<Integer>();
		rand = new Random();
		
		queue.add(rand.nextInt(4));
		queue.add(rand.nextInt(4));
		queue.add(rand.nextInt(4));
		queue.add(rand.nextInt(4));
		queue.add(rand.nextInt(4));
		queue.add(rand.nextInt(4));
	}
	
	public void addToQueue() {
		class MyRunnable implements Runnable {
			public void run() {
				try {
					queue.add(rand.nextInt(4));
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Runnable r = new MyRunnable();
		Thread t = new Thread(r);
		t.start();
	}
	
	public int deleteQueue() {
		return queue.remove();
	}
}
