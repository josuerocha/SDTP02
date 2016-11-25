

import java.rmi.Remote; 
import java.rmi.RemoteException; 

public interface ILeilao extends Remote { 

	boolean CadastrarLeilao(String entrada) throws RemoteException;
	
	String ConsultarLeilao() throws RemoteException;

}

