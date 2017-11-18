package Gartic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.ufsc.inf.leobr.cliente.Jogada;
import rede.AtorRede;
import rede.Mensagem;

public class AtorJogador{
	protected AtorRede atorRede;
	public Gartic gartic;
	protected OuveClique clique;
	InterfaceJogador telaJogo;
	public AtorJogador(){
	super();
	atorRede = new AtorRede(this);
	gartic = new Gartic();
	clique = new OuveClique(gartic.imagem,gartic.painel);
	}
	public void go(){
		telaJogo.jogador1.setText(gartic.jogador1.nome);
		telaJogo.jogador2.setText(atorRede.obterNomeAdversario());
		telaJogo.repaint();
		gartic.rodada = new Rodada(this);
    	gartic.rodada.start();
	}
	public void iniciaTela(){
		Interacoes interacao = new Interacoes();
		telaJogo = new InterfaceJogador(gartic);
		telaJogo.conectarSe.addActionListener(interacao);
		telaJogo.ApagarDesenho.addActionListener(interacao);
		telaJogo.desconectar.addActionListener(interacao);
		telaJogo.iniciarPartida.addActionListener(interacao);
		telaJogo.enviar.addActionListener(interacao);
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
	public void enviarJogada(){
		if(gartic.jogador1.desenha){
		atorRede.enviaJogada(new Mensagem(gartic.imagem,gartic.jogador1));
		gartic.rodada.tempo = 0;
		telaJogo.enviar.setVisible(false);
		}else{
		gartic.jogador1.tentativa = telaJogo.escreva.getText();
		telaJogo.respostas.append(gartic.jogador1.getTentativas()+"\n");
		atorRede.enviaJogada(new Mensagem(gartic.imagem,gartic.jogador1));	
		}
	}
	public void habilitarDesenho(){
		gartic.painel.addMouseMotionListener(clique);
	}
	public void desabilitarDesenho(){
		gartic.painel.removeMouseMotionListener(clique);
	}
	
	public void receberJogada(Jogada jogada) {
		Mensagem msg = (Mensagem)jogada;
		if(!gartic.jogador1.desenha){
			gartic.painel.receberDesenho(msg.getImagemGartic()); 
			gartic.painel.repaint();
			gartic.rodada.tempo = 0;
			telaJogo.respostas.setText("");
		}else if(gartic.jogador1.desenha){
			gartic.jogador2 = msg.getJogador();
			telaJogo.respostas.append(gartic.jogador2.tentativa+"\n");
		}
	}
	public static void main(String args[]){
		new AtorJogador().iniciaTela();
	}
	public class Interacoes implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if(command == telaJogo.conectarSe.getActionCommand()) {
				conectar();
			} else if (command == telaJogo.desconectar.getActionCommand()){
				desconectar();
			} else if (command == telaJogo.ApagarDesenho.getActionCommand()) {
				gartic.imagem.limpaArray();
				gartic.painel.repaint();
			} else if (command == telaJogo.iniciarPartida.getActionCommand())	{
				atorRede.iniciarPartidaRede();
			} else if (command == telaJogo.enviar.getActionCommand()) {
				if(gartic.jogador1.desenha){
					gartic.rodada.tempo = 0;
				}else{
					enviarJogada();
				}
			}
		}
	}
}
