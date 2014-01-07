import java.net.*;
import java.io.*;
import java.util.*;

public class ClientMulti{
	
	
	public static void main(String[] args) throws Exception {
		
		
		Socket socket = new Socket("localhost", 6000);
		PrintWriter sortie = new PrintWriter(socket.getOutputStream(),true);
		BufferedReader entree = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		Scanner sc = new Scanner(System.in);
		String str=sc.nextLine();
		
		System.out.println("Le client va envoyer son message : " + str);
		sortie.println(str); //Envoi du message
		String rep=entree.readLine();
		System.out.println("Le client a reçu : " + rep);
		
		
		
	}	
}