import java.util.ArrayList;

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
                 for(String str : leiloes){
                    System.out.println(str);
                
                }
                System.out.println("______________________");
                System.out.println(leiloes.length);
                if(leiloes.length > 0){
               
                String[] sample = leiloes[1].split(" ");
                
                if (sample.length == 5)
                tela.UpdateTela(leiloes);
                
                }
                
                sleep(500);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
