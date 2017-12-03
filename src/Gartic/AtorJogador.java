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
		telaJogo.jogadorLocal.setText(gartic.jogadorLocal.nome+" :");
		telaJogo.oponente.setText(atorRede.obterNomeAdversario()+" :");
		telaJogo.repaint();
		gartic.rodada = new Rodada(this);
		Thread thread = new Thread(gartic.rodada);
		thread.start();
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
		gartic.jogadorLocal.nome = JOptionPane.showInputDialog("Nome do Jogador");
		String ip = JOptionPane.showInputDialog("Insira o servidor");
		JOptionPane.showMessageDialog(null, "Tentando Conectar");
		atorRede.conectar(gartic.jogadorLocal.nome, ip);
	}
	public void desconectar(){
		atorRede.desconectar();
		System.exit(0);
	}
	public void iniciarPartida(int posicao){
		if (posicao == 1){
			gartic.jogadorLocal.desenha = true;
			habilitarDesenho();
			try {
				gartic.jogadorLocal.palavra = gartic.definirPalavraJogadorDesenha();
				telaJogo.desenho.setText(gartic.jogadorLocal.palavra);
			} catch (IOException e){}
		} else {
			gartic.jogadorLocal.desenha = false;
			telaJogo.enviar.setEnabled(false);
		}
		go();
	}
	public void atualizarTelaJogador(){
		if(gartic.jogadorLocal.desenha){
			habilitarDesenho();
			telaJogo.desenho.setText(gartic.jogadorLocal.palavra);
			telaJogo.enviar.setEnabled(true);
			telaJogo.respostas.setText("");
		}else{
			telaJogo.enviar.setEnabled(false);
			telaJogo.desenho.setText("");
			telaJogo.respostas.setText("");
		}
	}
	
	public void enviarJogada(){
		if(gartic.jogadorLocal.desenha){
		atorRede.enviaJogada(new Mensagem(gartic.imagem,gartic.jogadorLocal));
		telaJogo.enviar.setEnabled(false);
		desabilitarDesenho();
		}else if (!gartic.jogadorLocal.desenha){
		gartic.jogadorLocal.tentativa = telaJogo.escreva.getText();
		telaJogo.escreva.setText("");
		telaJogo.respostas.append(gartic.jogadorLocal.getTentativa()+"\n");
		atorRede.enviaJogada(new Mensagem(gartic.imagem,gartic.jogadorLocal));
		gartic.rodada.tentativas++;
		if(gartic.jogadorLocal.tentativa.equals(gartic.jogadorLocal.palavra)){
			gartic.jogadorLocal.acertou = true;
			gartic.oponente.acertou = true;
			gartic.rodada.encerrarRodada();
		}else if(gartic.rodada.tentativas>4){
			gartic.rodada.encerrarRodada();
		}
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
		if(!gartic.jogadorLocal.desenha){
			gartic.rodada.tempo = 0;
			gartic.painel.receberDesenho(msg.getImagemGartic()); 
			gartic.jogadorLocal.palavra = msg.getJogador().palavra;
			gartic.oponente = msg.getJogador();
			gartic.painel.repaint();
			telaJogo.enviar.setEnabled(true);
		}else if(gartic.jogadorLocal.desenha){
			gartic.oponente = msg.getJogador();
			telaJogo.respostas.append(msg.getJogador().tentativa+"\n");
			gartic.rodada.tentativas++;
			if(gartic.oponente.tentativa.equals(gartic.oponente.palavra)){
				gartic.jogadorLocal.acertou = true;
				gartic.oponente.acertou = true;
				gartic.rodada.encerrarRodada();
			}else if(gartic.rodada.tentativas>4){
				gartic.rodada.encerrarRodada();
			}
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
				if(gartic.jogadorLocal.desenha){
					gartic.rodada.tempo = 0;
				}else{
					enviarJogada();
				}	
			}
					
		}
	}
}
