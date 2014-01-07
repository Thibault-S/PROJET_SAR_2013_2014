import java.net.*;
import java.io.*;
//elhaddad@lamsade.dauphine.fr

public class ThreadClient extends Thread{
	
	private String str="";
	private Socket port;
	
	public ThreadClient(Socket port){
		this.port=port;
	}
	
	
	public void run(){	
		
		try{
	

			BufferedReader entree = new BufferedReader(new InputStreamReader( this.port.getInputStream()));
			PrintWriter sortie = new PrintWriter(this.port.getOutputStream(),true);	
			//System.out.println("Bienvenue sur le Serveur " +this.getName());	
			
			
		
		do{	
			System.out.println("Debug");
			str=entree.readLine(); //Attente d'un message
			if (str.equals("lancé?")){
				System.out.println("Bien lancé");
			}
			/*try{
				Thread.sleep(5000);//Simulation de tache
			}catch(InterruptedException e){}*/
			
			//System.out.println("Serveur a reçu " + str);
			sortie.println( this.getName()+ " : Message reçu");	
			//System.out.println("Test " + str);
			
		}while(!str.equals("Bye"));
		
		entree.close();
		sortie.close();
		
		}catch(IOException e){}
			finally{
					try{
						port.close();
					}catch(IOException e){}
				
			}

	}	
}