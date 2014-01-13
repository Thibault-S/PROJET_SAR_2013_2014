/*  

╔══════════════╦════════════════════════════════════════════════════════════╗
║  ( (         ║						2013-2014							║
║    ) )	   ║				Université Dauphine Paris 9					║
║  ........	   ║					Master 1 - MIAGE						║
║  |      |]   ║			Projet Systèmes & Algorithmes Répartis			║
║  \      /    ╟────────────────────────────────────────────────────────────╢
║   `----'     ║	Axel Richier - Thibault Schleret - Guillaume Fronczak   ║
╚══════════════╩════════════════════════════════════════════════════════════╝

*/

import java.net.*;
import java.io.*;
import java.util.ArrayList;


public class Ligne{

	private int numero;
	private boolean bouchon =false;
	private int arret_bouchon;
	private ArrayList<String> ListeDesArrets  = new ArrayList<String>();
	private ArrayList<Bus> ListeDesBusSurLigne  = new ArrayList<Bus>();
	
	//Tableau d'affectation des lignes
	private static ArrayList<Integer> Affectation=new ArrayList<Integer>();
	
	public void setBouchon(boolean b,int num_arret){
		bouchon=b;
		arret_bouchon=num_arret;
	}
	public int getDelaiEntreStations(int num_ligne,int pos, int vitesse){
			int coef=0;
			int rep=0;
			if(!bouchon){
				if ((vitesse>=0)&&(vitesse<10))
					coef=5;
				if ((vitesse>=10)&&(vitesse<20))
					coef=4;
				if ((vitesse>=20)&&(vitesse<30))
					coef=3;
				if ((vitesse>=30)&&(vitesse<40))
					coef=2;
				if ((vitesse>=40)&&(vitesse<=50))
					coef=1;
			}else if(bouchon||(arret_bouchon==pos)){
				coef=6;
			}	
				if(num_ligne==0){
					if(pos==0)
						rep= 6000*coef;
					if(pos==1)
						rep= 3000*coef;
					if(pos==2)
						rep= 7000*coef;
					if(pos==3)
						rep= 1500*coef;
					if(pos==4)
						rep= 3000*coef;
					if(pos==5)
						rep= 3000*coef;
				}
				if(num_ligne==1){
					if(pos==0)
						rep= 1000*coef;
					if(pos==1)
						rep= 1020*coef;
					if(pos==2)
						rep= 1110*coef;
					if(pos==3)
						rep= 4030*coef;
					if(pos==4)
						rep= 2000*coef;
					if(pos==5)
						rep= 2200*coef;
				}
				
				if(num_ligne==2){
					if(pos==0)
						rep= 1000*coef;
					if(pos==1)
						rep= 1030*coef;
					if(pos==2)
						rep= 4000*coef;
					if(pos==3)
						rep= 8500*coef;
					if(pos==4)
						rep= 3000*coef;
					if(pos==5)
						rep= 6000*coef;
					if(pos==6)
						rep= 3500*coef;
					if(pos==7)
						rep= 6000*coef;
					if(pos==8)
						rep= 3500*coef;
				}
				if(num_ligne==3){
					if(pos==0)
						rep= 1000*coef;
					if(pos==1)
						rep= 1030*coef;
					if(pos==2)
						rep= 4000*coef;
					if(pos==3)
						rep= 8500*coef;
					if(pos==4)
						rep= 3000*coef;
					if(pos==5)
						rep= 6000*coef;
					if(pos==6)
						rep= 3500*coef;
					if(pos==7)
						rep=1000*coef;
					if(pos==8)
						rep= 1030*coef;
					if(pos==9)
						rep= 4000*coef;
					if(pos==10)
						rep= 8500*coef;
					if(pos==11)
						rep= 3000*coef;
					
				}
				if(num_ligne==4){
					if(pos==0)
						rep= 1000*coef;
					if(pos==1)
						rep= 1030*coef;
					if(pos==2)
						rep= 4000*coef;
					if(pos==3)
						rep= 8500*coef;
					if(pos==4)
						rep= 3000*coef;
					if(pos==5)
						rep= 6000*coef;
					if(pos==6)
						rep= 3500*coef;
					if(pos==7)
						rep= 6000*coef;
					if(pos==8)
						rep= 3500*coef;
				}
				if(num_ligne==5){
					if(pos==0)
						rep= 1000*coef;
					if(pos==1)
						rep= 1030*coef;
					if(pos==2)
						rep= 4000*coef;
					if(pos==3)
						rep= 8500*coef;
					if(pos==4)
						rep= 3000*coef;
					if(pos==5)
						rep= 6000*coef;
					if(pos==6)
						rep= 3500*coef;
				}
				if(num_ligne==6){
					if(pos==0)
						rep= 1000*coef;
					if(pos==1)
						rep= 1030*coef;
					if(pos==2)
						rep= 4000*coef;
					if(pos==3)
						rep= 8500*coef;
					if(pos==4)
						rep= 3000*coef;
					if(pos==5)
						rep= 6000*coef;
					if(pos==6)
						rep= 3500*coef;
					if(pos==7)
						rep= 3000*coef;
					if(pos==8)
						rep= 6000*coef;
					if(pos==9)
						rep= 3500*coef;
				}
				bouchon=false;
			return rep;
	}
	public int nbArret(){
		return ListeDesArrets.size();
	
	}
	public String getArret(int i){
		return ListeDesArrets.get(i);
	
	}

	public int nbBusSurLigne(){
		return this.ListeDesBusSurLigne.size();
	
	}
	
	public Bus getBus(int i){
		return this.ListeDesBusSurLigne.get(i);
	}
	
	public int getNumBus(int i){
		return this.ListeDesBusSurLigne.get(i).getNumBus();
	}

	public void addBusSurLigne(Bus b){
		this.ListeDesBusSurLigne.add(b);
	
	}

	public int getNumLigne(){
	
		return this.numero;
	}

	public Ligne(int i){
		//DEBUG
		/*System.out.println("Création de la ligne N°"+i);//*/

		
		if(i==1){
			this.numero=1;
			ListeDesArrets.add("Défense     ");
			ListeDesArrets.add("Etoile      ");
			ListeDesArrets.add("Georges V   ");
			ListeDesArrets.add("Palais Royal");
			ListeDesArrets.add("Bastille    ");
			ListeDesArrets.add("Vincennes   ");
				}
		if(i==2){
			this.numero=2;
			ListeDesArrets.add("Pte Dauphine");
			ListeDesArrets.add("Vic. Hugo ");
			ListeDesArrets.add("Clichy    ");
			ListeDesArrets.add("Pigalle   ");
			ListeDesArrets.add("Col. Fabien");
			ListeDesArrets.add("Ph. Auguste");
				}
		if(i==3){
			this.numero=3;
			ListeDesArrets.add("Louise Michel");
			ListeDesArrets.add("Champerret");
			ListeDesArrets.add("Europe    ");
			ListeDesArrets.add("St Lazare ");
			ListeDesArrets.add("Caumartin ");
			ListeDesArrets.add("Bourse    ");
			ListeDesArrets.add("Sentier   ");
			ListeDesArrets.add("Parmentier");
			ListeDesArrets.add("Gambetta  ");
				}
		if(i==4){
			this.numero=4;
			ListeDesArrets.add("Clignancourt");
			ListeDesArrets.add("Simplon     ");
			ListeDesArrets.add("Chat Rouge  ");
			ListeDesArrets.add("Marcel      ");
			ListeDesArrets.add("Chatelet    ");
			ListeDesArrets.add("Les Halles  ");
			ListeDesArrets.add("Cité U      ");
			ListeDesArrets.add("St Germain  ");
			ListeDesArrets.add("Odéon       ");
			ListeDesArrets.add("St Sulpice  ");
			ListeDesArrets.add("Vavin       ");
			ListeDesArrets.add("Alésia     ");
			
				}
		if(i==5){
			this.numero=5;
			ListeDesArrets.add("Bobigny   ");
			ListeDesArrets.add("Hoche     ");
			ListeDesArrets.add("Ourson    ");
			ListeDesArrets.add("Lumière   ");
			ListeDesArrets.add("Stalingrad");
			ListeDesArrets.add("République");
			ListeDesArrets.add("Oberkampf ");
			ListeDesArrets.add("Lenoir    ");
			ListeDesArrets.add("Bastille  ");
				}
		if(i==6){
			this.numero=6;
			ListeDesArrets.add("Champs Elysées");
			ListeDesArrets.add("Dupleix ");
			ListeDesArrets.add("Montparnasse");
			ListeDesArrets.add("Edgar Quinet");
			ListeDesArrets.add("Raspail");
			ListeDesArrets.add("Place d'Italie ");
			ListeDesArrets.add("Nation");
				}
		if(i==7){
			this.numero=7;
			ListeDesArrets.add("La Courneuve");
			ListeDesArrets.add("Aubervilliers");
			ListeDesArrets.add("Gare de l'Est");
			ListeDesArrets.add("Cadet     ");
			ListeDesArrets.add("Pont Neuf");
			ListeDesArrets.add("Sully Morland");
			ListeDesArrets.add("Opera   ");
			ListeDesArrets.add("Pyramides");
			ListeDesArrets.add("Jussieu");
			ListeDesArrets.add("Les Gobelins");
			
				}
	
	
	}
	
	
	
	public void afficher_ligne(){
		System.out.println("Ligne " + this.numero);
		for(int i=0; i< this.ListeDesArrets.size(); i++){
			
			System.out.println("Arrêt N°" + i + " : " + this.ListeDesArrets.get(i) +".");
		
		}
		
		
		
	}

}

