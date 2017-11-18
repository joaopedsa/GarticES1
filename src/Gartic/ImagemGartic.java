package Gartic;

import br.ufsc.inf.leobr.cliente.Jogada;

public class ImagemGartic implements Jogada{
protected Ponto[][] pontos = new Ponto[450][300];
	public void addFigura(Ponto ponto){		
		pontos[ponto.x][ponto.y] = ponto;
		}
	public void limpaArray(){
		pontos = new Ponto[450][300];
			}
	}
//}
