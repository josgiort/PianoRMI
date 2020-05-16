import java.rmi.Remote;
import java.rmi.RemoteException;


public interface CancionesInterface extends Remote{
    
    public String [] getCancion1 () throws RemoteException;

    public int [] getSilencios1 () throws RemoteException;
    
    public String [] getCancion2 ()throws RemoteException;

    public int [] getSilencios2 () throws RemoteException;
    
    public String [] getCancion3 () throws RemoteException;

    public int [] getSilencios3 () throws RemoteException;
    
    public String [] getCancion4 () throws RemoteException;

    public int [] getSilencios4 () throws RemoteException;
    
    public String [] getCancion5 () throws RemoteException;

    public int [] getSilencios5 () throws RemoteException;
    
    public String [] getCancion6 () throws RemoteException;

    public int [] getSilencios6 () throws RemoteException;
    
}
