package Gartic;


import javax.swing.*;


public class Rodada extends Thread {
JTextField textoTempo;
int tentativas;
int tempo = 0;
int numeroRodada = 1;
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
		
			for (tempo = 50; tempo >= 0; tempo--) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
				textoTempo.setText("Tempo "+tempo+" seg");
			}
			if(atorJogador.gartic.jogador1.desenha)
				atorJogador.enviarJogada();
			for(tempo = 30; (tempo >= 0 && tentativas <4) && !atorJogador.gartic.jogador1.desenha ; tempo--){
				try{
					Thread.sleep(1000);
					if(atorJogador.gartic.jogador1.palavra.equals(atorJogador.gartic.jogador1.tentativa))
						tempo = 0;
				}catch(InterruptedException e){}
				textoTempo.setText("Tempo "+ tempo+" seg");
			}
			encerrarRodada();
		}
	}