package Gartic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
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
		ConexaoListener conexao = new ConexaoListener();
		telaJogo.conectarSe.addActionListener(conexao);
		telaJogo.ApagarDesenho.addActionListener(conexao);
		telaJogo.desconectar.addActionListener(conexao);
		telaJogo.iniciarPartida.addActionListener(conexao);
		gartic.jogador1.nome = JOptionPane.showInputDialog("Insira seu Nome : ");
		//atorRede.conectar(gartic.jogador1.nome, "localhost");
		//if(atorRede.desenha())
			gartic.painel.addMouseMotionListener(gartic.clique);
		gartic.rodada = new Rodada(telaJogo.tempo);
    	Thread threadTempo = new Thread(gartic.rodada);
    	threadTempo.start();
	}
	public JFrame getFrame(){
		return telaJogo;
	}
	public static void main(String args[]){
		new AtorJogador().go();
	}
	public class ConexaoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem) e.getSource();
			if(item == telaJogo.conectarSe) {
				atorRede.conectar(gartic.jogador1.nome, "localhost");
			} else if (item == telaJogo.desconectar){
				atorRede.desconectar();
				System.exit(0);
			} else if (item == telaJogo.ApagarDesenho) {
				gartic.imagem.limpaArray();
				gartic.painel.repaint();
			} else if (item == telaJogo.iniciarPartida)	{
				atorRede.iniciarPartidaRede();
			}
		}
	}
	public void receberMensagemRede(Gartic gartic) {
		gartic = gartic;
	}
}
