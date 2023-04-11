package game.Mar.inputs;
//класс кнопки 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import game.Mar.Enter.Game;
import game.Mar.Enter.GamePanel;
import static utilz.Constants.Directions.*;

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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
   
}

		@Override
		public void keyReleased(KeyEvent e) {
			  switch (e.getKeyCode()) {
			  case KeyEvent.VK_W:
			  case KeyEvent.VK_A:
			  case KeyEvent.VK_S:
			  case KeyEvent.VK_D:
				  gamePanel.setMoving(false);
				  break;
				  
			  }
		}
		@Override
		public void keyPressed(KeyEvent e) {
			
	  switch (e.getKeyCode()) {
	  case KeyEvent.VK_W:
		  //ПОЛУЧИЛИ доступ к игровой панели  СЫЛКИ НА ИГРАВУЮ ПАНЕЛЬ И ВСТАВИЛИ параметры
		  gamePanel.setDirection(UP);
		  break;
	  case KeyEvent.VK_A:
		  gamePanel.setDirection(LIFT);
		  break;
	  case KeyEvent.VK_S:
		  gamePanel.setDirection(DOWN);
		  break;
	  case KeyEvent.VK_D:
		  gamePanel.setDirection(RIGHT);
		  break;
		  
	  }
			
		}
	

}
