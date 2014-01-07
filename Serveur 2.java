import java.net.*;
import java.io.*;
public class Serveur{

	public static void main(String[] args) throws Exception{

	ServerSocket s = new ServerSocket(6000);
	System.out.println("Serveur prêt à recevoir un message. ");

	Socket soc = s.accept();
	BufferedReader entree = new BufferedReader(new InputStreamReader( soc.getInputStream()));
	PrintWriter sortie = new PrintWriter(soc.getOutputStream(),true);	
	for(int i=0; i<10 ; i++){
		
		String str=entree.readLine();
		System.out.println("Serveur a reçu " + str);
		sortie.println("test");	
	}	
	entree.close();
	sortie.close();
	soc.close();
	}
}