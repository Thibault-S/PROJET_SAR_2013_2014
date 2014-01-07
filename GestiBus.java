import java.net.*;
import java.io.*;


public class GestiBus{
	
	
	public static void ecranAccueil(){
		System.out.println(" o========================================o");
		System.out.println("||   ___ ___ ___ _____ ___ ___ _   _ ___  ||");
		System.out.println("||  / __| __/ __|_   _|_ _| _ ) | | / __| ||");
		System.out.println("|| | (_ | _|\\__ \\ | |  | || _ \\ |_| \\__ \\ ||");
		System.out.println("||  \\___|___|___/ |_| |___|___/\\___/|___/ ||");
		System.out.println(" o========================================o");	
	}
	
	
	public static void verifServeur() throws Exception{
		System.out.print("Vérification du lancement du Serveur.");
		
		Socket socket = new Socket("localhost", 6000);
		PrintWriter sortie = new PrintWriter(socket.getOutputStream(),true);
		BufferedReader entree = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		
		sortie.println("lancé?"); //Envoi du message
		String rep=entree.readLine();
		System.out.println("Le client a reçu : " + rep);
	
	
	}
	
	public static void main(String[] args) throws Exception{
		
		ecranAccueil();
		verifServeur();
	
	
	}
}