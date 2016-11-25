
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ThreadBusca extends Thread {

    Tela tela;
    ILeilao leilao;

    public ThreadBusca(Tela tela, ILeilao leilao) {
        this.tela = tela;
        this.leilao = leilao;
    }

    public void run() {
        try {
            while (true) {

                String[] leiloes = leilao.ConsultarLeilao();
                if (leiloes.length > 1) {
                    String[] sample = leiloes[1].split(" ");

                    if (sample.length == 5) {
                        for(int i = 1; i<leiloes.length; i++){
                        
                        String leilaoPartido[] = leiloes[i].split(" ");
                        if(Integer.parseInt(leilaoPartido[4]) == 0){
                            int code = Integer.parseInt(leilaoPartido[0]);
                            String vencedor = leilao.getVencedor(code);
                            JOptionPane.showMessageDialog(null, vencedor);
                        }
                            
                            
                        }
                        
                        tela.UpdateTela(leiloes);
                    }

                }
                sleep(500);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
