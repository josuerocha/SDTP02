

import java.rmi.Remote; 
import java.rmi.RemoteException; 
import java.util.ArrayList;

public interface ILeilao extends Remote { 

	boolean CadastrarLeilao(String entrada) throws RemoteException;
	
	String[] ConsultarLeilao() throws RemoteException;
        
        boolean DarLance(int code, String user , double value) throws RemoteException;
        
        String getVencedor(int code) throws RemoteException;

}

