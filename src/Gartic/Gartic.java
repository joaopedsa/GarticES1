package Gartic;

import javax.swing.JFrame;

public class Gartic extends JFrame {
	protected ImagemGartic imagem = new ImagemGartic();
	protected Reprodutor painel = new Reprodutor(imagem);
	protected OuveClique clique = new OuveClique(imagem,painel);
	protected Jogador jogador1;
	protected Jogador jogador2;
	protected Rodada rodada;
	public Gartic(){
		
	}
}
