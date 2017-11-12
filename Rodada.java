import javax.swing.*;

public class Rodada {

    public  Rodada(JTextField tempo) throws InterruptedException {
        contaTempo(tempo);
    }

    public void contaTempo(JTextField tempo) throws InterruptedException {
        for (int i = 59; i >= 0 ; i--) {
            Thread.sleep(1000);
            tempo.setText("Tempo "+i+" seg");
        }
    }
    public void respostas(JTextArea respostas) {
        respostas.setText("Respostas:");
    }
}
