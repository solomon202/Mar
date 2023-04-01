package game.Mar.inputs;
//класс кнопки 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.Mar.Enter.GamePanel;

public class Keyboardsinput  implements KeyListener {
	//есть доступ к игровой панели в нутри клавиотуры
	//сылка 
	private GamePanel gamePanel;
	//получения реальной сылки 
	public Keyboardsinput(GamePanel gamePanel) {
		//присваивание реального обьекта 
		this.gamePanel = gamePanel;
	}
	
		@Override
		public void keyPressed(KeyEvent e) {
			
	  switch (e.getKeyCode()) {
	  case KeyEvent.VK_W:
		  //ПОЛУЧИЛИ доступ к игровой панели  СЫЛКИ НА ИГРАВУЮ ПАНЕЛЬ И ВСТАВИЛИ параметры
		  gamePanel.changeYDelta(-5);
		  break;
	  case KeyEvent.VK_A:
		  gamePanel.changeXDelta(-5);
		  break;
	  case KeyEvent.VK_S:
		  gamePanel.changeYDelta(5);
		  break;
	  case KeyEvent.VK_D:
		  gamePanel.changeXDelta(5);
		  break;
		  
	  }
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
	   
   }
	

}
