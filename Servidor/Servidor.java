
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;


public class Servidor extends UnicastRemoteObject implements ILeilao{

    String itensLeilao = "";

    public Servidor() throws RemoteException {
        super();
    }

    public boolean CadastrarLeilao(String entrada){
        itensLeilao = itensLeilao + entrada + "\n";
        System.out.println(itensLeilao);
        return true;
    };

    public String ConsultarLeilao() {
        System.out.println("Consulta realizada!");
        return itensLeilao;
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
