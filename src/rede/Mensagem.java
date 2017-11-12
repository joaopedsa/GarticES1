package rede;

import Gartic.Gartic;

public class Mensagem implements br.ufsc.inf.leobr.cliente.Jogada {

	private Gartic gartic;
	
	Mensagem(Gartic gartic){
		super();
		this.gartic = gartic;
	}

	public Gartic getMensagem(){
		return gartic;
	}
}
