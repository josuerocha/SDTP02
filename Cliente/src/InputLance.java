import javax.swing.*;

public class InputLance {
    public InputLance(Tela tela){
        
      JTextField codeProduto = new JTextField(5);
      JTextField valor = new JTextField(5);
      JTextField tempo = new JTextField(5);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Codigo do produto:"));
      myPanel.add(codeProduto);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Valor:"));
      myPanel.add(valor);
      int result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Entre com os dados do leilão", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
          tela.codeProdutoLance = Integer.parseInt(codeProduto.getText());
          tela.valorLance = Double.parseDouble(valor.getText());
          tela.lanceBool = true;
      }
   }
}