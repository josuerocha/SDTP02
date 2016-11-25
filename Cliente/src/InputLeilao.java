import javax.swing.*;

public class InputLeilao {
    public InputLeilao(Tela tela){
        
      JTextField produto = new JTextField(5);
      JTextField valor = new JTextField(5);
      JTextField tempo = new JTextField(5);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Produto:"));
      myPanel.add(produto);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Valor:"));
      myPanel.add(valor);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Tempo:"));
      myPanel.add(tempo);

      int result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Entre com os dados do leilão", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
          tela.nome = produto.getText();
          tela.valor = valor.getText();
          tela.tempo = tempo.getText();
          tela.newProduct = true;
          
      }
   }
}