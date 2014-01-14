
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChoixControleur extends Remote {
    String getControleur() throws RemoteException;
}