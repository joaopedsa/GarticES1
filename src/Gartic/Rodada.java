package Gartic;


import javax.swing.*;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Rodada extends Thread {
JTextField textoTempo;
int tentativas;
String palavraParaDesenhar;
int pontuacaoDesenha;
int pontuacaoAdivinha;
int tempo = 0;
AtorJogador atorJogador;
	public Rodada(AtorJogador atorJogador) {
		this.atorJogador = atorJogador;
		this.textoTempo = atorJogador.telaJogo.tempo;
    }
    public void respostas(JTextArea respostas) {
        respostas.setText("Escreva Aqui!");
    }
    public void tentarResposta(String palavraDigitada, JTextArea respostas){
    	respostas.append(palavraDigitada+"\n");
    }
    public void encerrarRodada(){
    
    }
    public int getTentativa(){
    	return tentativas;
    }
	@Override
	public void run() {
		for (tempo = 50; tempo >= 0 ; tempo--) {
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
            textoTempo.setText("Tempo "+tempo+" seg");
        }
		atorJogador.enviarjogada();
	}
}