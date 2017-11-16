package Gartic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
		telaJogo.jogador1.setText(gartic.jogador1.nome);
		telaJogo.jogador2.setText(atorRede.obterNomeAdversario());
		telaJogo.repaint();
		gartic.rodada = new Rodada(telaJogo.tempo);
    	Thread threadTempo = new Thread(gartic.rodada);
    	threadTempo.start();
	}
	public void iniciaTela(){
		ConexaoListener conexao = new ConexaoListener();
		telaJogo = new InterfaceJogador(gartic);
		telaJogo.conectarSe.addActionListener(conexao);
		telaJogo.ApagarDesenho.addActionListener(conexao);
		telaJogo.desconectar.addActionListener(conexao);
		telaJogo.iniciarPartida.addActionListener(conexao);
	}
	
	public JFrame getFrame(){
		return telaJogo;
	}
	public void conectar(){
		gartic.jogador1.nome = JOptionPane.showInputDialog("Nome do Jogador");
		atorRede.conectar(gartic.jogador1.nome, "localhost");
	}
	public void desconectar(){
		atorRede.desconectar();
		System.exit(0);
	}
	public void iniciarPartida(int posicao){
		if (posicao == 1){
			gartic.jogador1.desenha = true;
			habilitarDesenho();
			try {
				telaJogo.desenho.setText(gartic.definirPalavraJogadorDesenha());
			} catch (IOException e){}
		} else {
			gartic.jogador2.desenha = false;
		}
		go();
	}
	public void habilitarDesenho(){
		gartic.painel.addMouseMotionListener(gartic.clique);
	}
	public void desabilitarDesenho(){
		gartic.painel.removeMouseMotionListener(gartic.clique);
	}
	public void receberMensagemRede(Gartic gartic) {
		this.gartic = gartic;
	}
	public static void main(String args[]){
		new AtorJogador().iniciaTela();
	}
	public class ConexaoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem) e.getSource();
			if(item == telaJogo.conectarSe) {
				conectar();
			} else if (item == telaJogo.desconectar){
				desconectar();
			} else if (item == telaJogo.ApagarDesenho) {
				gartic.imagem.limpaArray();
				gartic.painel.repaint();
			} else if (item == telaJogo.iniciarPartida)	{
				atorRede.iniciarPartidaRede();
			}
		}
	}
}
