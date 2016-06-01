package Communication;
import java.net.*;



import java.io.*;

// Gets messages from client and puts them in a queue, for another
// thread to forward to the appropriate client.

public class ServerReceiver extends Thread {
  private String myClientsName;
  private BufferedReader myClient;
 // private ClientTable clientTable;
  private boolean running=true;

  public ServerReceiver(String n, BufferedReader c) {
    myClientsName = n;
    myClient = c;
    //clientTable = t;
  }

  public void stopThread()
  {
	  running=false;
  }
  
  public void run() {
    try {
	      while (running) {
		        String msg = myClient.readLine();
		        if(msg != null)
			    {		
		        		
			       	switch(msg)
			       	{
			        	
			        	
			       	case "quit":
			       		for(int i=0;i<=Server.listOfConnections.size();i++)
			       		{			     
			       			ClientConnection con=Server.listOfConnections.get(i);
			       			if(con.clientName.equals(myClientsName))con.stopTreads();
			       			Server.listOfConnections.remove(i);
			       			i=Server.listOfConnections.size()+1;
			       		}
				       	System.out.println(myClientsName + " disconnected");
				       	running=false;
				       	break;
			       	
				    default:  
				    	
			       	} 	
			        	
			     
			    }
		  }
	      
    }
    catch (IOException e) {
      System.err.println("Something went wrong with the client " 
                       + myClientsName + " " + e.getMessage()); 
      // No point in trying to close sockets. Just give up.
      // We end this thread (we don't do System.exit(1)).
    }
  }
}
