import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class server 
	implements Runnable{

	private Socket socket;//SOCKET INSTANCE VARIABLE
	Scanner in;
	PrintWriter out;
	String user;
	
	public server(Socket s)
	{
		socket = s;//INSTANTIATE THE SOCKET
	}
	
	@Override
	public void run() //(IMPLEMENTED FROM THE RUNNABLE INTERFACE)
	{
		try //HAVE TO HAVE THIS FOR THE in AND out VARIABLES
		{
			in = new Scanner(socket.getInputStream());//GET THE SOCKETS INPUT STREAM (THE STREAM THAT YOU WILL GET WHAT THEY TYPE FROM)
			out = new PrintWriter(socket.getOutputStream());//GET THE SOCKETS OUTPUT STREAM (THE STREAM YOU WILL SEND INFORMATION TO THEM FROM)
			
			while (true)//WHILE THE PROGRAM IS RUNNING
			{		
				if (in.hasNext())
				{
					String input = in.nextLine();//IF THERE IS INPUT THEN MAKE A NEW VARIABLE input AND READ WHAT THEY TYPED
					System.out.println(input);//PRINT IT OUT TO THE SCREEN
					out.println(input);//RESEND IT TO THE CLIENT
					out.flush();//FLUSH THE STREAM
				}
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();//MOST LIKELY THERE WONT BE AN ERROR BUT ITS GOOD TO CATCH
		}	
	}
}