//Projet SAR 2013-2014

import java.net.*;
import java.io.*;



public class Bus implements Runnable{
	
	public Thread proc = new Thread(this); //Creation du thread
	private boolean en_marche=false;
	private int vitesse;
	private int position;
	private int num_bus;
	
	private void envoyerInfos() throws Exception{
		
		System.out.println("Le bus "+ num_bus +" envoie ses infos au Serveur.");
		
		Socket socket = new Socket("localhost", 6000);
		
		PrintWriter sortie = new PrintWriter(socket.getOutputStream(),true);
		BufferedReader entree = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		
		sortie.println("BUS;"+num_bus); //Envoi du message
		String rep=entree.readLine();
		
		if(rep.equals("OKBUS")){
			System.out.println("[OK] Infos reçues par le serveur");
		}
		//System.out.println("Le client a reçu : " + rep);
	
	
	}
	
	
	public void run(){
		while(this.en_marche==true){
		
			try
			 {
				Thread.sleep(3000);
				System.out.println("Bus " + num_bus + " en Marche");
				envoyerInfos();
			 }
			 
			catch
			 (Exception e) {
			
				break;
			 }
		
		}
		
		System.out.println("Bus " + num_bus + " arrêté.");

	}
	
	
	
	public Bus(int num_bus){
	
		this.num_bus=num_bus;
		en_marche=true;
	
	}
	
	public void fin_de_journee(){
		
		this.en_marche=false;
	
	}
	
	
	
	
	}