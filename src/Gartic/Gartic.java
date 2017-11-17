package Gartic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Gartic implements Jogada{
	protected ImagemGartic imagem;
	protected Reprodutor painel;
	public Jogador jogador1;
	protected Jogador jogador2;
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
		jogador1 = new Jogador();
		jogador2 = new Jogador();
	}
	public boolean verificarAtingiuPontuacao(){
		return true;
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
	        aleatorio = radom.nextInt(21);
	        palavra = lines.get(aleatorio);
	        return palavra;
	    }
	public void definirJogadorQueDesenha(){
	}
	public ImagemGartic enviarDesenho(){
		return imagem;
	}
	public Gartic getGartic(){
		return this;
	}
	public void setTipoJogada(int tipoJogada){
	}
	public boolean informarConectado(){
		return conectados;
	}
	public int getTipoJogada(){
		return tipoJogada;
	}
	public void encerrarRodada(){
	}
	public boolean checarSeGanhou(){
		return true;
	}
	public void finalizarPartida(){
	}
	public void iniciarNovaRodada(){
	}
	public void resetar(){
	}
	public boolean informarEmAndamanto(){
		return partidaEmAndamento;
	}
	public boolean informarDesenha(){
		return jogador1.desenha;
	}
}
