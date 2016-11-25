
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Servidor extends UnicastRemoteObject implements ILeilao{

    static ArrayList <String> leiloes;

    static ArrayList <String> lances;

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

    public boolean DarLance(int code, String user, double value){
	System.out.println("LANCADO");
	boolean lancado = true;
	if(code > 0){


		String str[] = leiloes.get(code).split(" ");
		if(Double.parseDouble(str[3]) >= value  || str[1].contains(user)){
			lancado = false;
		}

		if(lancado){
			lances.add(code + " " + user + " " + value);
			leiloes.set(code,str[0] + " " + str[1] + " " + str[2] + " " + value + " " + str[4] );
		}
	}

	return lancado;

    }
	

    public static void main(String args[]) {
	leiloes = new ArrayList<String>();
	lances = new ArrayList<String>();
	leiloes.add("vazio");
	lances.add("vazio");

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
