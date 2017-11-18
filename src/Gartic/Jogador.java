package Gartic;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Jogador implements Jogada{
String nome;
int pontuacao;
boolean desenha;
boolean vencedor;
String tentativa;
String palavra;

public String getTentativas(){
	return tentativa;
}
public int getPontuacao(){
	return pontuacao;
}
public boolean getDesenha(){
	return desenha;
}
public boolean getVencedor(){
	return vencedor;
}
public String getNome(){
	return nome;
}
}
