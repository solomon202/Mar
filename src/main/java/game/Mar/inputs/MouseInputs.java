package game.Mar.inputs;
//класс мышка 
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import game.Mar.Enter.GamePanel;

public class MouseInputs implements MouseListener,MouseMotionListener {
	//получаем доступ к панели 
	private GamePanel gamePanel;
	public MouseInputs(GamePanel gamePanel) {
		this.gamePanel=gamePanel;
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		//gamePanel.setRectPos(e.getX(),e.getY());
		
	}
//позицыя треугольника перемещение курсора вместе с обьектом
	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
