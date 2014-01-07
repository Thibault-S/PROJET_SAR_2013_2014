//Projet SAR 2013-2014

import java.net.*;
import java.io.*;
import java.util.ArrayList;


public class GestiBus{
	
	private static int NB_Bus=1;
	private static ArrayList<Bus> TousLesBus  = new ArrayList<Bus>();
	
	public static void ecranAccueil(){
		System.out.println(" o========================================o");
		System.out.println("||   ___ ___ ___ _____ ___ ___ _   _ ___  ||");
		System.out.println("||  / __| __/ __|_   _|_ _| _ ) | | / __| ||");
		System.out.println("|| | (_ | _|\\__ \\ | |  | || _ \\ |_| \\__ \\ ||");
		System.out.println("||  \\___|___|___/ |_| |___|___/\\___/|___/ ||");
		System.out.println(" o========================================o");	
	}
	
	
	public static void initBus(){
		
		int i;
		for(i=0;i<NB_Bus;i++){
			TousLesBus.add(new Bus(i));
		} 
		if(TousLesBus.size()==NB_Bus){
			System.out.println("[OK] Création des "+NB_Bus+" bus.");
		}else{
			System.out.println("[Erreur] Création des "+NB_Bus+" bus.");
		}
		
	
	}
	
	
	public static void verifServeur() throws Exception{
		System.out.println("Vérification du lancement du Serveur.");
		
		Socket socket = new Socket("localhost", 6000);
		PrintWriter sortie = new PrintWriter(socket.getOutputStream(),true);
		BufferedReader entree = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		
		sortie.println("lancé?"); //Envoi du message
		String rep=entree.readLine();
		
		if(rep.equals("OK")){
			System.out.println("[OK] Serveur Lancé");
		}
		//System.out.println("Le client a reçu : " + rep);
	
	
	}
	
	public static void lancerBus(){
		for(int i=0;i<NB_Bus;i++){
			TousLesBus.get(i).proc.start();
			
		}
		
	
	}
	public static void terminerBus(){
		System.out.println("Fin de journée les cocos.");
		
		for(int i=0;i<NB_Bus;i++){
			TousLesBus.get(i).fin_de_journee();
			
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		ecranAccueil();
		verifServeur();
		initBus();
		lancerBus();
		try
			 {
				Thread.sleep(10000);
				
			 }
			 
			catch
			 (InterruptedException e) {
			
				
			 }
		terminerBus();
	
	
	}
}