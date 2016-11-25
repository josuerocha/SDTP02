
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Servidor extends UnicastRemoteObject implements ILeilao{

    static ArrayList<String> leiloes = new ArrayList<String>();


    public Servidor() throws RemoteException {
        super();
    }

    public boolean CadastrarLeilao(String entrada){
        leiloes.add(entrada);
	System.out.println("Cadastro feito");
        return true;
    };

    public ArrayList<String> ConsultarLeilao() {
	if(leiloes.size() == 0){
        	System.out.println("Consulta realizada!");
        	leiloes.add("Empty");
		System.out.println("chato " + leiloes.size());
	}
	return leiloes;
    }
	

    public static void main(String args[]) {

        try {
            Servidor servidor = new Servidor();
            Naming.rebind("rmi://localhost/Leilao", servidor);
	    
            System.out.println("Conectado no registro RMI");
        } 
        catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
            ex.printStackTrace();
        }

    }
}
