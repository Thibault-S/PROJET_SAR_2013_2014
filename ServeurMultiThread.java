import java.net.*;
import java.io.*;


public class ServeurMultiThread  {

	//private Socket soc;
	//private BufferedReader in;
	//private PrintWriter out;
	
	//public ServeurMultiThread(Socket soc){
	//	this.soc= soc;
	//}
	
		
	public static void main(String[] args) throws Exception{
		System.out.println("Lancement du serveur");
		int i=0;
		ServerSocket s = new ServerSocket(6000);
			
		while(true){
			Socket soc = s.accept();
			ThreadClient th = new ThreadClient(soc);
			th.start();
			
			
		}
		
	}
}