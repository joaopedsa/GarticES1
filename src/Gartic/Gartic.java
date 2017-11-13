package Gartic;

public class Gartic{
	protected ImagemGartic imagem = new ImagemGartic();
	protected Reprodutor painel = new Reprodutor(imagem);
	protected OuveClique clique = new OuveClique(imagem,painel);
	protected Jogador jogador1 = new Jogador();
	protected Jogador jogador2 = new Jogador();
	protected Rodada rodada;
	public Gartic(){
		
	}
}
