import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {

    static Scanner scan = new Scanner(System.in);

    static ILeilao servidorLeilao = null;
    
    static Tela tela;

    public static void main(String args[]) {
        tela = new Tela();
        tela.setVisible(true);
        try {
            servidorLeilao = (ILeilao) Naming.lookup("rmi://localhost/Leilao");
            
            while(true){
                System.out.println("Escolha uma opção (ler ou cadastrar): ");
                String option = scan.nextLine();
                
                switch(option){    
                    case "ler":
                        String consulta = servidorLeilao.ConsultarLeilao();
                        System.out.println(consulta);
                    break;

                    case "cadastrar":
                        String cadastro = scan.nextLine();
                        boolean result = servidorLeilao.CadastrarLeilao(cadastro);
                        if(result){ System.out.println("Cadastrado com sucesso.");}
                        else{ System.out.println("Falha ao cadastrar."); }
    
                    break;
                }

                
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
