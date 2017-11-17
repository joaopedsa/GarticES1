package rede;

import javax.swing.JOptionPane;

import Gartic.AtorJogador;
import Gartic.Gartic;
import Gartic.ImagemGartic;
import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;

public class AtorRede implements OuvidorProxy {

	private AtorJogador atorJogador;
	
	private Proxy proxy;
	
	boolean desenha = false;
	
	boolean iniciou = false;
	public AtorRede(AtorJogador atorJogador){
		super();
		this.atorJogador = atorJogador;
		proxy = Proxy.getInstance();
		proxy.addOuvinte(this);
	}
	
	/**
	 * Conecta o jogo ao servidor.
	 * @param nome
	 * @param servidor
	 */
	public void conectar(String nome, String servidor){
		try {
			proxy.conectar(servidor, nome);
		} catch (JahConectadoException e) {
			JOptionPane.showMessageDialog(atorJogador.getFrame(), e.getMessage());
			e.printStackTrace();
		} catch (NaoPossivelConectarException e) {
			JOptionPane.showMessageDialog(atorJogador.getFrame(), e.getMessage());
			e.printStackTrace();
		} catch (ArquivoMultiplayerException e) {
			JOptionPane.showMessageDialog(atorJogador.getFrame(), e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Inicia uma partida entre cliente e servidor.
	 */
	public void iniciarPartidaRede(){
		try {
			proxy.iniciarPartida(2);
		} catch (NaoConectadoException e) {
			JOptionPane.showMessageDialog(atorJogador.getFrame(), e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public void iniciarNovaPartida(Integer posicao) {
		atorJogador.iniciarPartida(posicao);
	}
	
	public void enviaJogada(Mensagem msg){
		try {
			proxy.enviaJogada(msg);
		} catch (NaoJogandoException e) {
			JOptionPane.showMessageDialog(atorJogador.getFrame(), e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public void receberJogada(Jogada jogada) {
		atorJogador.receberJogada(jogada);
	}
	
	public void desconectar(){
		try {
			proxy.desconectar();
		} catch (NaoConectadoException e) {
			JOptionPane.showMessageDialog(atorJogador.getFrame(), e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public void finalizarPartidaComErro(String message) {
		JOptionPane.showMessageDialog(atorJogador.getFrame(), message);

	}

	@Override
	public void tratarConexaoPerdida() {
		JOptionPane.showMessageDialog(atorJogador.getFrame(), "A conexão com o servidor foi perdida!");

	}

	@Override
	public void tratarPartidaNaoIniciada(String message) {
		JOptionPane.showMessageDialog(atorJogador.getFrame(), "Não foi Possivel iniciar Partida");

	}
	
	@Override
	public void receberMensagem(String msg) {
		// TODO Auto-generated method stub

	}

	public String obterNomeAdversario() {
		String nome;
		if (atorJogador.gartic.informarDesenha()){
			nome = proxy.obterNomeAdversario(2);
		}else{
			nome = proxy.obterNomeAdversario(1);
		}
		return nome;
	}

	public boolean iniciou(){
		return iniciou;
	}

}
