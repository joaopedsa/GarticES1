package rede;

import Gartic.ImagemGartic;
import Gartic.Jogador;;

public class Mensagem implements br.ufsc.inf.leobr.cliente.Jogada {

	protected ImagemGartic imagem;
	protected Jogador jogador;
	
	public Mensagem(ImagemGartic imagem,Jogador jogador){
		super();
		this.imagem = imagem;
		this.jogador = jogador;
	}
	public ImagemGartic getImagemGartic(){
		return imagem;
	}
	public Jogador getJogador(){
		return jogador;
	}
}
