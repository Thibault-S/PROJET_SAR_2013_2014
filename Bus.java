//Projet SAR 2013-2014

import java.net.*;
import java.io.*;



public class Bus implements Runnable{
	
	public Thread proc = new Thread(this); //Creation du thread
	private boolean en_marche=false;
	private int vitesse;
	private int position;
	
	
	public void run(){
		while(this.en_marche==true){
		
			try
			 {
				Thread.sleep(2000);
				System.out.println("Bus en Marche");
			 }
			 
			catch
			 (InterruptedException e) {
			
				break;
			 }
		
		}
		
		
	
	
	
	}
	
	private int num_bus;
	
	public Bus(int num_bus){
	
		this.num_bus=num_bus;
		en_marche=true;
	
	}
	
	public void fin_de_journee(){
		
		this.en_marche=false;
	
	}
	
	
	
	
	}