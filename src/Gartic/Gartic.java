package Gartic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JOptionPane;

public class Gartic{
	protected ImagemGartic imagem;
	protected Reprodutor painel;
	protected Jogador jogadorLocal;
	protected Jogador oponente;
	protected Rodada rodada;
	protected String palavraDesenhada;
	protected boolean conectados;
	protected boolean partidaEmAndamento;
	protected boolean acertou;
	protected boolean vencedor;
	protected int tipoJogada;
	public Gartic(){
		imagem = new ImagemGartic();
		painel = new Reprodutor(imagem);;
		jogadorLocal = new Jogador();
		oponente = new Jogador();
	}
	public boolean verificarAtingiuPontuacao(){
		vencedor = (jogadorLocal.pontuacao >= 160) || (oponente.pontuacao >= 160);
		return vencedor;
	}
	public String definirPalavraJogadorDesenha() throws IOException{
	        String palavra = null;
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("palavras.txt")));
	        String line = null;
	        int lineNumber = 0;
	        HashMap<Integer, String> lines = new HashMap<Integer, String>();
	        while ((line = bufferedReader.readLine()) != null) {
	            lines.put(lineNumber, line);
	            lineNumber++;
	        }
	        bufferedReader.close();

	        Random radom  = new Random();
	        int aleatorio = 0;
	        aleatorio = radom.nextInt(37);
	        palavra = lines.get(aleatorio);
	        return palavra;
	    }
	public void definirJogadorQueDesenha(){
		if(jogadorLocal.desenha){
			jogadorLocal.desenha = false;
			oponente.desenha = true;
		}else{
			jogadorLocal.desenha = true;
			oponente.desenha = false;
		}
	}
	public ImagemGartic enviarDesenho(){
		return imagem;
	}
	public Gartic getGartic(){
		return this;
	}
	public boolean informarConectado(){
		return conectados;
	}
	public int getTipoJogada(){
		return tipoJogada;
	}
	public void aplicarPontuacao(){
		if((jogadorLocal.desenha && jogadorLocal.acertou)){
			jogadorLocal.pontuacao = jogadorLocal.pontuacao + 40;
			switch(rodada.tentativas){
			case 1:
				oponente.pontuacao = oponente.pontuacao + 60;
				break;
			case 2:
				oponente.pontuacao = oponente.pontuacao + 40;
				break;
			case 3:
				oponente.pontuacao = oponente.pontuacao + 20;
				break;
			case 4:
				oponente.pontuacao = oponente.pontuacao + 10;
				break;
			}
		}else if(!jogadorLocal.desenha && jogadorLocal.acertou) {
			switch(rodada.tentativas){
			case 1:
				jogadorLocal.pontuacao = jogadorLocal.pontuacao + 60;
				break;
			case 2:
				jogadorLocal.pontuacao = jogadorLocal.pontuacao + 40;
				break;
			case 3:
				jogadorLocal.pontuacao = jogadorLocal.pontuacao + 20;
				break;
			case 4:
				jogadorLocal.pontuacao = jogadorLocal.pontuacao + 10;
				break;
			}
			oponente.pontuacao = oponente.pontuacao + 40;
		}
	}
	public void finalizarPartida(){
		imagem.limpaArray();
		painel.receberDesenho(imagem);
		painel.repaint();
		jogadorLocal.acertou = false;
		oponente.acertou = false;
		if(jogadorLocal.getPontuacao()>oponente.getPontuacao()){
			JOptionPane.showMessageDialog(null, "Jogador " + jogadorLocal.nome+" Venceu!");
			System.exit(0);
		}else{
			JOptionPane.showMessageDialog(null, "Jogador " + oponente.nome+" Venceu!");
			System.exit(0);
		}
	}
	public void iniciarNovaRodada(){
		definirJogadorQueDesenha();
		imagem.limpaArray();
		painel.receberDesenho(imagem);
		painel.repaint();
		jogadorLocal.acertou = false;
		oponente.acertou = false;
		if(jogadorLocal.desenha){
			try{
			jogadorLocal.palavra = definirPalavraJogadorDesenha();
			}catch(Exception e){}
		}
		Thread thread = new Thread(rodada);
		thread.start();
	}
	public boolean informarDesenha(){
		return jogadorLocal.desenha;
	}
}
