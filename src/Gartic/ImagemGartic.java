package Gartic;

public class ImagemGartic {
protected Ponto[][] pontos = new Ponto[450][250];
	public void addFigura(Ponto ponto){		
		pontos[ponto.x][ponto.y] = ponto;
		}
	public void limpaArray(){
		pontos = new Ponto[450][250];
			}
	}
//}
