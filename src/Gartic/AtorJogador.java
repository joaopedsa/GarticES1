package Gartic;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import rede.AtorRede;

public class AtorJogador {
	protected AtorRede atorRede;
	public Gartic gartic;
	InterfaceJogador telaJogo;
	public AtorJogador(){
	super();
	atorRede = new AtorRede(this);
	gartic = new Gartic();
	}
	public void go(){
		telaJogo = new InterfaceJogador(gartic);
		gartic.painel.addMouseMotionListener(gartic.clique);
	}
	public JFrame getFrame(){
		return telaJogo;
	}
	
	public static void main(String args[]){
		new AtorJogador().go();
	}
	public void receberMensagemRede(Gartic mensagem) {
		gartic = mensagem;
	}
}
