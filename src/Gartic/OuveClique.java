package Gartic;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class OuveClique implements MouseMotionListener{
	ImagemGartic imagem;
	Reprodutor painel;
	OuveClique(ImagemGartic imagem,Reprodutor painel){
		this.imagem = imagem;
		this.painel = painel;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		try {
			Point ponto = painel.getMousePosition();
			imagem.addFigura(new Ponto(ponto.x,ponto.y));
		}catch(Exception ey){}
		painel.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
