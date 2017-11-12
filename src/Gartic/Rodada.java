package Gartic;

import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class Rodada implements Runnable {
JTextField tempo;
    public Rodada(JTextField tempo) {
        this.tempo = tempo;
    }
    public void respostas(JTextArea respostas) {
        respostas.setText("Respostas:");
    }
	@Override
	public void run() {
		for (int i = 50; i >= 0 ; i--) {
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
            tempo.setText("Tempo "+i+" seg");
        }
		
	}
}