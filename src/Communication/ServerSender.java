package Communication;




import java.io.*;

// Continuously reads from message queue for a particular client,
// forwarding to the client.

public class ServerSender extends Thread {
  private MessageQueue queue=null;
  private PrintStream client;
  private boolean running=true;

  public ServerSender(MessageQueue q, PrintStream c) {
    queue = q;   
    client = c;
    
  }


  public void stopThread()
  {
	  running=false;
  }
  
  
  public void run() {
    while (running) {
    	if(queue!=null)
    	{
	      String msg = queue.take();
	      client.println(msg);
    	}
    }
  }
}
