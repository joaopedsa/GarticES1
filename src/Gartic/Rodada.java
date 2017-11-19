package Gartic;


import javax.swing.*;


public class Rodada implements Runnable {
JTextField textoTempo;
int tentativas = 0;
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
    	numeroRodada++;
    	atorJogador.gartic.aplicarPontuacao();
    	atorJogador.telaJogo.pontuacaoJogadorLocal.setText(""+atorJogador.gartic.jogadorLocal.pontuacao);
    	atorJogador.telaJogo.pontuacaoOponente.setText(""+atorJogador.gartic.oponente.pontuacao);
    	if(!atorJogador.gartic.verificarAtingiuPontuacao()){
    		atorJogador.telaJogo.rodada.setText("Rodada "+numeroRodada);
    		atorJogador.gartic.iniciarNovaRodada();
    		atorJogador.atualizarTelaJogador();
    		tentativas = 0;
    	}else{
    		if(atorJogador.gartic.jogadorLocal.pontuacao>atorJogador.gartic.oponente.pontuacao){
    			JOptionPane.showMessageDialog(null, "Você ganhou!!");
    			System.exit(0);
    		}else{
    			JOptionPane.showMessageDialog(null, "Você Perdeu!");
    			System.exit(0);
    		}
    	}
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
			if(atorJogador.gartic.jogadorLocal.desenha){
				atorJogador.enviarJogada();
				atorJogador.telaJogo.tempo.setText("Espere o Adversário");
			}else{
				atorJogador.telaJogo.tempo.setText("Sua Vez!");
			}
	}
}