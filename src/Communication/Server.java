package Communication;


import java.net.*;
import java.util.ArrayList;

import Communication.ClientConnection;
import Communication.Port;
import java.io.*;

public class Server {
	
	public static ServerSocket serverSocket = null;
	public static ArrayList<ClientConnection> listOfConnections=new ArrayList<ClientConnection>();
	
	public static void main(String [] args) {

	    // We must try because it may fail with a checked exception:
	    try {
	      serverSocket = new ServerSocket(Port.number);
	    } 
	    catch (IOException e) {
	      System.err.println("Couldn't listen on port " + Port.number);
	      System.exit(1); // Give up.
	    }
	  
	    while (true) {
	    	// Listen to the socket, accepting connections from new clients:
	          Socket socket;
	  		try {
	  			socket = serverSocket.accept();
	  		
	
	          // This is so that we can use readLine():
	          BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	          // We ask the client what its name is:
	          String clientName = fromClient.readLine();
	          // For debugging:
	          System.out.println(clientName + " connected");
	          
	          ClientConnection connection=new ClientConnection(socket,clientName,fromClient);
	          listOfConnections.add(connection);
	    	  connection.run();
	          
	  		} catch (IOException e) {
				 // Lazy approach:
			      System.err.println("IO error " + e.getMessage());		      
			}          
	    }   
	}
}
