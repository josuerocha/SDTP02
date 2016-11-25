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
                System.out.println("Conslutando");
                tela.UpdateTela(leilao.ConsultarLeilao());
                
            }

        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("Exceção man");
        }
    }

}
