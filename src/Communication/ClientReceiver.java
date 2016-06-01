package Communication;
import java.io.*;
import java.net.*;


// Gets messages from other clients via the server (by the
// ServerSender thread).

public class ClientReceiver extends Thread {

  private BufferedReader server;
  private boolean running=true;
  private PrintStream printServer;
  

  ClientReceiver(BufferedReader server,PrintStream PrintServer) {
    this.server = server;
    this.printServer=PrintServer;
  }

  
  public void stopThread()
  {
	  running=false;
	  
	  System.exit(0);
  }
  
  public void run() {
    // Print to the user whatever we get from the server:
    try {
      while (running)
      {
    	  String s = server.readLine();        
	      if (s != null){
	        		
	        	
	        	
	      }else{
	    	  if(Client.closed)
	    	  {
	    		  running=false;
	    	  }else{
	    	  server.close(); // Probably no point.  
	    	  throw new IOException("Got null from server"); // Caught below.     
	    	  }
	      }
      }
    }
    catch (IOException e) {
      System.out.println("Server seems to have died " + e.getMessage());
      System.exit(1); // Give up.
    }
  }
}
