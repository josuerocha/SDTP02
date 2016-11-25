import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Cliente {
    
    static ThreadBusca busca;

    static ILeilao servidorLeilao = null;
    
    static Tela tela;
    
    public void VerificarVencedor(String vencedor){
        JOptionPane.showMessageDialog (null, vencedor, "Vencedor", JOptionPane.INFORMATION_MESSAGE);
    }


    public static void main(String args[]) {
        try {
            
            servidorLeilao = (ILeilao) Naming.lookup("rmi://localhost/Leilao");
            busca = new ThreadBusca(tela,servidorLeilao);
            
            tela = new Tela(servidorLeilao);
            tela.setVisible(true);
        
            busca.start();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
