package Gartic;


import javax.swing.*;


public class Rodada implements Runnable {
JLabel textoTempo;
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
    public void zerarTempo(){
    	tempo = 0;
    }
    public void incTentativas(){
    	tentativas++;
    }
    /*!
     * aplica a pontua��o;
     * verifica se existe um vencedor;
     * se existir acaba o jogo;
     * caso n�o inicia uma nova rodada e atualiza tela dos jogadores;
     */
    public void encerrarRodada(){
    	numeroRodada++;
    	atorJogador.gartic.aplicarPontuacao();
    	atorJogador.telaJogo.pontuacaoJogadorLocal.setText(""+atorJogador.gartic.jogadorLocal.getPontuacao());
    	atorJogador.telaJogo.pontuacaoOponente.setText(""+atorJogador.gartic.oponente.getPontuacao());
    	if(!atorJogador.gartic.verificarAtingiuPontuacao()){
    		atorJogador.telaJogo.rodada.setText("Rodada "+numeroRodada);
    		atorJogador.gartic.iniciarNovaRodada();
    		atorJogador.atualizarTelaJogador();
    		tentativas = 0;
    	}else{
    		atorJogador.gartic.finalizarPartida();
    	}
    }
    public int getTentativa(){
    	return tentativas;
    }
	@Override
	//conta o tempo de 50 a 0,mas caso o jogador aperte enviar zera o tempo;
	public void run() {
			for (tempo = 50; tempo >= 0; tempo--) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
				textoTempo.setText("Tempo "+tempo+" seg");
			}
			if(atorJogador.gartic.jogadorLocal.desenha){
				atorJogador.realizarJogada();
				atorJogador.telaJogo.tempo.setText("");
				JOptionPane.showMessageDialog(null, "Aguarde a Jogada do Advers�rio!");
			}else{
				atorJogador.telaJogo.tempo.setText("");
				JOptionPane.showMessageDialog(null, "Sua vez de Adivinhar!");
			}
	}
}