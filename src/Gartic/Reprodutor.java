package Gartic;

import java.awt.*;

import javax.swing.*;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Reprodutor extends JPanel{
	protected ImagemGartic imagem;
	Reprodutor(ImagemGartic imagem){
		this.imagem = imagem;
	}
	public void receberDesenho(ImagemGartic imagem){
		this.imagem = imagem;
	}
	  public void paintComponent(Graphics g) {
		    super.paintComponent(g);
		      for(int i = 0; i <imagem.pontos.length; i++) {
		    	  for(int j = 0 ; j < imagem.pontos[0].length;j++)
		    		  if(imagem.pontos[i][j]!=null)
		    			  imagem.pontos[i][j].reproduzir(g);
		      }
		  }
		}
