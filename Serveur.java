import java.net.*;
import java.io.*;
public class Serveur{

	public static void main(String[] args) throws Exception{

	// Assignation du socket d'écoute
	ServerSocket s = new ServerSocket(6000);
	
	//Affichages écran
	System.out.println("Serveur de bus lancé.");
	System.out.println("Serveur prêt à recevoir des messages.");
	
	//Ecoute
		while(true){
			Socket soc=s.accept();
			
			ThreadClient th= new ThreadClient(soc);
			
			th.start();
		}
	}
}
