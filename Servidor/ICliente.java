    
import java.rmi.Remote; 
import java.rmi.RemoteException; 

public interface ICliente extends Remote {
    
    public void NotificarVencedor(String vencedor);

    public void UpdateTela(String[] info);
    
}
