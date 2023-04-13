package game.Mar.Enter;
//класс где компануются все остальные компоненты 
public class Game implements Runnable {
	//сылочные 
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private final int FPS_SET = 120;
	private final int USP_SET = 200;
	
	public Game() {
		gamePanel = new GamePanel();
		gameWindow = new GameWindow(gamePanel);
	  //Элемент requestFocus (раздел Advanced) позволяет установить фокус на нужном компоненте. Предположим, что у вас имеется три текстовых поля, и нужно, чтобы фокус был на втором поле. В этом случае достаточно добавить тег requestFocus внутри нужного элемента:
		//Компонент является объектом, имеющим графическое изображение, которое может быть выведено на экран на экране, и это может взаимодействовать с пользователем. Примерами компонентов являются кнопки, флажки, и полосы прокрутки типичного графического интерфейса пользователя.
		gamePanel.requestFocus();
		startGameLoop();
}
	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	
	
	
	public void run() {
		//переменная кадров и время и новое время 
		double timePerFrame = 1000000000.0/FPS_SET;
		double timePerUpdate =1000000000.0/USP_SET;
		long lastFrame  = System.nanoTime();
		long now = System.nanoTime();
		
		long previousTime = System.nanoTime();
		
		
		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();
		
		
		double deltaU = 0;
		
		while(true) {
			now = System.nanoTime();
			long currentTime = System.nanoTime();
			deltaU += (currentTime - previousTime)/timePerUpdate;
			previousTime = currentTime;
			
			if (deltaU >=1){
				updates++;
				deltaU--;
			}
			
			if(now - lastFrame >= timePerFrame) {
				gamePanel.repaint();
				lastFrame = now;
			}
			
		}
		
		}
	}
