
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
                if (leiloes.length > 1) {
                    String[] sample = leiloes[1].split(" ");

                    if (sample.length == 5) {
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
