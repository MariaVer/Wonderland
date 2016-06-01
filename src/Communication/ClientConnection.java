package Communication;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ClientConnection {
	
	public Socket socket = null;
	public String clientName;
	public BufferedReader fromClient;
	public MessageQueue queue;
	public ServerReceiver receiver;
	public ServerSender sender;
	
	public ClientConnection(Socket socket,String clientname,BufferedReader fromClient)
	{
		this.socket=socket;
		this.clientName=clientname;
		this.fromClient=fromClient;
	}
	
	public void stopTreads()
	{
		try {
			
			receiver.stopThread();
			sender.stopThread();		
			socket.close();
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		
		try {
			
        // We create and start a new thread to read from the client:
        receiver=new ServerReceiver(clientName, fromClient);
        receiver.start();

        // We create and start a new thread to write to the client:
        PrintStream toClient;		
		toClient = new PrintStream(socket.getOutputStream());
		
        sender=new ServerSender(queue, toClient);
        sender.start();       
		
		} catch (IOException e1) {			
			e1.printStackTrace();
		}
		
	}
}
