package Communication;
// We use https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/BlockingQueue.html

import java.util.concurrent.*;



public class MessageQueue {

  // We choose the LinkedBlockingQueue implementation of BlockingQueue:
  private BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
  
    
  // Inserts the specified message into this queue.
  public void offer(String m) {
    queue.offer(m);
  }

  public boolean isEmpty()
  {
	  if(queue.isEmpty()) return true;
	  else return false;
  }
  // Retrieves and removes the head of this queue, waiting if
  // necessary until an element becomes available.
  public String take() {

    while (true) {
      try {
        return(queue.take());
      }
      catch (InterruptedException e) {
        // This can in principle be triggered by queue.take().
        // But this would only happen if we had interrupt() in our code,
        // which we don't.
        // In any case, if it could happen, we should do nothing here
        // and try again until we succeed without interruption.
      }

    }
  }
}
