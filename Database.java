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
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
	
public class Database  extends Thread implements Choix{
	
	
	private static int NB_Lignes;
	private static int NB_Controleurs;
	
	private static ArrayList<Integer> Repartition  = new ArrayList<Integer>();
	
	public int getControleur(int num_ligne) {
		return Repartition.get(num_ligne);
    }
	
	private void afficherTableauRepartition(int nb){
		for(int i=0;i<nb;i++){
			System.out.print("|"+i+"   ");			
		}
		System.out.println();
		for(int i=0;i<nb;i++){
			System.out.print("|"+Repartition.get(i)+"   ");			
		}
		System.out.println();
	}
	
    public Database(int nb_lignes,int nb_controleurs) {
    	
    	
    	
    	for(int i=0; i< nb_lignes ; i++){
    				
    				Repartition.add(i%nb_controleurs);
    		}
    			
    	
    	
    	//afficherTableauRepartition(nb_lignes);
    	
    	
    }//*/
    
    public static ArrayList<Integer> getRepartition(){
    	return Repartition;
    }

    public Database(){}
   	
   /*	public void run(){
   		NB_Lignes=GestiBus.get_nb_Lignes();
		NB_Controleurs=GestiBus.get_nb_Controleurs();
	
		try {
		    Database obj = new Database(NB_Lignes,NB_Controleurs);
		    Choix stub = (Choix) UnicastRemoteObject.exportObject(obj, 0);
	
		    // Bind the remote object's stub in the registry
		    Registry registry = LocateRegistry.getRegistry();
		    registry.bind("Choix", stub);
	
		    System.err.println("Database ready");
		} catch (Exception e) {
		    System.err.println("Database exception: " + e.toString());
		    e.printStackTrace();
		}
   		
   	}//*/
	
    public static void main(String args[]) {
    	NB_Lignes=GestiBus.get_nb_Lignes();
		NB_Controleurs=GestiBus.get_nb_Controleurs();
	
	try {
	    Database obj = new Database(NB_Lignes,NB_Controleurs);
	    Choix stub = (Choix) UnicastRemoteObject.exportObject(obj, 0);

	    // Bind the remote object's stub in the registry
	    Registry registry = LocateRegistry.getRegistry();
	    registry.bind("Choix", stub);

	    System.err.println("Database ready");
	} catch (Exception e) {
	    System.err.println("Database exception: " + e.toString());
	    e.printStackTrace();
	}
    }//*/
}
