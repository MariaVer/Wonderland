package Communication;
// Usage:
//        java Client user-nickname hostname
//
// After initializing and opening appropriate sockets, we start two
// client threads, one to send messages, and another one to get
// messages.
//
// A limitation of our implementation is that there is no provision
// for a client to end after we start it. However, we implemented
// things so that pressing ctrl-c will cause the client to end
// gracefully without causing the server to fail.
//
// Another limitation is that there is no provision to terminate when
// the server dies.


import java.io.*;
import java.net.*;
import java.util.Scanner;




class Client {
	
	public static ClientSender sender;
	public static ClientReceiver receiver;	
	public static PrintStream toServer;	
	public static boolean closed=false;
	
	public static void closeThreads()
	{		
		sender.stopThread();
		receiver.stopThread();
		System.exit(0);	
	}
	
	
  public static void main(String[] args) {

    // Check correct usage:
    if (args.length != 2) {
      System.err.println("Usage: java Client user-nickname hostname");
      System.exit(1); // Give up.
    }
    
    String nickname = args[0];
    String hostname = args[1];
    
    // Open sockets:
    toServer = null;
    BufferedReader fromServer = null;
    Socket server = null;

    try {
      server = new Socket(hostname, Port.number);
      toServer = new PrintStream(server.getOutputStream());
      fromServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
      
    } 
    catch (UnknownHostException e) {
      System.err.println("Unknown host: " + hostname);
      System.exit(1); // Give up.
    } 
    catch (IOException e) {
      System.err.println("The server doesn't seem to be running " + e.getMessage());
      System.exit(1); // Give up.
    }

    // Create two client threads:
    sender = new ClientSender(nickname,toServer,fromServer);
    receiver = new ClientReceiver(fromServer,toServer);

    // Run them in parallel:
    sender.start();
    receiver.start();
    
    // Wait for them to end and close sockets.
    try {
      sender.join();
      toServer.close();
      receiver.join();
      fromServer.close();
      server.close();
    }
    catch (IOException e) {
      System.err.println("Something wrong " + e.getMessage());
      System.exit(1); // Give up.
    }
    catch (InterruptedException e) {
      System.err.println("Unexpected interruption " + e.getMessage());
      System.exit(1); // Give up.
    }
  }
}
