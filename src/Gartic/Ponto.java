package Gartic;

import java.awt.Graphics;
public class Ponto {
protected int x;
protected int y;
	Ponto(int x , int y){
		this.x = x;
		this.y = y;
	}

	public void reproduzir(Graphics g){
		g.fillRect(x, y, 3, 3);
	}
}
