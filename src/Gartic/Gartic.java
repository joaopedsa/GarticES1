package Gartic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;

public class Gartic{
	protected ImagemGartic imagem = new ImagemGartic();
	protected Reprodutor painel = new Reprodutor(imagem);
	protected OuveClique clique = new OuveClique(imagem,painel);
	public Jogador jogador1 = new Jogador();
	protected Jogador jogador2 = new Jogador();
	protected Rodada rodada;
	protected String palavraDesenhada;
	protected boolean conectados;
	protected boolean partidaEmAndamento;
	protected boolean acertou;
	protected boolean vencedor;
	protected int tipoJogada;
	public Gartic(){
		
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
