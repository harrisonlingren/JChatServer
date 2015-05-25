import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class serverMain {

	private static PrintStream sysLog;
	
	public static void main(String[] args) 
			throws IOException {
		
		try {
			final int PORT = 6677;//SET NEW CONSTANT VARIABLE: PORT
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(PORT); //SET PORT NUMBER
			System.out.println("Waiting for clients...");//AT THE START PRINT THIS
		
			while (true)//WHILE THE PROGRAM IS RUNNING
			{												
				Socket s = server.accept();//ACCEPT SOCKETS(CLIENTS) TRYING TO CONNECT
				
				System.out.println("Client connected from " + s.getLocalAddress().getHostName());	//	TELL THEM THAT THE CLIENT CONNECTED
				server chat = new server(s);//CREATE A NEW CLIENT OBJECT
				
				System.out.println("Enter username:  ");
				
				
				Thread t = new Thread(chat);//MAKE A NEW THREAD
				t.start();//START THE THREAD
				
				sysLog = new PrintStream(s.getOutputStream());
				System.setOut(sysLog);
				//chat.user = chat.in.next();
			}
		} 
		catch (Exception e) 
		{
			System.out.println("An error occured.");//IF AN ERROR OCCURED THEN PRINT IT
                        e.printStackTrace();
		}
	}
}