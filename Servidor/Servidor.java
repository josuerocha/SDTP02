
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Servidor extends UnicastRemoteObject implements ILeilao{

    static ArrayList <String> leiloes;

    int codAtual = 1;

    public Servidor() throws RemoteException {
        super();
    }

    public boolean CadastrarLeilao(String entrada){
	entrada = codAtual + " " + entrada;
        leiloes.add(entrada);
	codAtual++;
	System.out.println("Cadastro feito");
        return true;
    };

    public String[] ConsultarLeilao() {
	String[] stockArr = new String[leiloes.size()];
	stockArr = leiloes.toArray(stockArr);

	return stockArr;
    }
	

    public static void main(String args[]) {
	leiloes = new ArrayList<String>();
	leiloes.add("vazio");

	TimeCounter timeCounter = new TimeCounter();
	timeCounter.start();

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
