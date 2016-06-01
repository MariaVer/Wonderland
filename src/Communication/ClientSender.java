package Communication;
import java.io.*;


// Repeatedly reads recipient's nickname and text from the user in two
// separate lines, sending them to the server (read by ServerReceiver
// thread).

public class ClientSender extends Thread {

  private String nickname;
  private PrintStream server;
  private boolean running;
  private BufferedReader serverRead;
  
  ClientSender(String nickname, PrintStream server,BufferedReader serverRead) {
	this.serverRead=serverRead;
    this.nickname = nickname;
    this.server = server;
    running=true;
  }

  public void stopThread()
  {
	  running=false;
	  System.exit(0);
  }
  
  public void run() {
    // So that we can use the method readLine:
    BufferedReader user = new BufferedReader(new InputStreamReader(System.in));

    try 
    {
	      // Tell the server what my nickname is:
	      server.println(nickname);
	      
	      // Then loop forever sending messages to recipients via the server:
	      while (running) 
	      {
		    	
		        String msg = user.readLine();
		        switch(msg)
		        {
		       
			        case "quit":
			        	Client.closed=true;
			        	server.println("quit");
			        	Client.closeThreads();
			        	break;
			        
			        	
			    	default:
		    		
		        }  
	      }
    }
    catch (IOException e) {
      System.err.println("Communication broke in ClientSender" 
                        + e.getMessage());
      System.exit(1);
    } 
  }
}

