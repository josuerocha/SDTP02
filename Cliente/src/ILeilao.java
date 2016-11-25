

import java.rmi.Remote; 
import java.rmi.RemoteException; 
import java.util.ArrayList;

public interface ILeilao extends Remote { 

	boolean CadastrarLeilao(String entrada) throws RemoteException;
	
	ArrayList<String> ConsultarLeilao() throws RemoteException;

}

