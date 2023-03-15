package game.Mar.Enter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;

import game.Mar.inputs.Keyboardsinput;
import game.Mar.inputs.MouseInputs;

public class GamePanel extends JPanel{
	//есть уже заданые параметры или получить через конструктор изменяемые данные .
	private MouseInputs mouseInputs;
	private  float xDelta =100,yDelta = 100;
	private float xDir = 1f, yDir = 1f;
	private int frames = 0;
	private long lastCheck = 0;
	private Color color = new Color(150,20,90);
	private Random random;
	
   public GamePanel() { 
	   
	   random = new Random();
	   mouseInputs = new MouseInputs(this);                                        
	   // для обработки событий клавиатуры необходимо реализовать специальный интерфейс, а затем добавить получившегося слушателя к интересуемому компоненту. 
	   addKeyListener(new Keyboardsinput(this));
	   //эти интерфейса содержат методы, принимающие и обрабатывающие различные типы событий от мыши
	   addMouseListener(mouseInputs);
	   addMouseMotionListener(mouseInputs);
	   
   }
   //метод с получаемым параметром 
   public void changeXDelta(int value) {
	   //есть какаята картинка изночально позицыя квадрата 100 потом при нажатии присваиваиваится новая позиция дельта 0 и перересовыется уже не 0
	   //тоесть  это позиция и + новая дэльта.
	   this.xDelta += value;
	  
   }
   
   public void changeYDelta(int value) {
	   this.yDelta += value;
	   
   }
   
   public void setRectPos(int x,int y) {
	   this.xDelta = x;
	   this.yDelta = y;
	   
   }
   
   public void paintComponent(Graphics g) {
	   super.paintComponent(g);
	   
	   updateRectangle();
	   g.setColor(color);
	   //прямоугольник 100+дельта его позицыя
	   g.fillRect((int)xDelta, (int)yDelta,200 , 50);
	   frames++;
	   //количество кадров 
	   if(System.currentTimeMillis()- lastCheck >= 1000) {
		   lastCheck = System.currentTimeMillis();
		   System.out.println("FPS: " + frames);
		   frames = 0;
	   }
	   
  
   }
   //обновление кадров
     private  void updateRectangle() {
    	 xDelta += xDir;
    	 if(xDelta > 400 || xDelta < 0) {
    		 xDir *= -1;
    	 color = getRndColor();
     }
    	 yDelta += yDir;
    	 if(yDelta > 400 || yDelta < 0)
    		 yDir *= -1;
    	// color = getRndColor();
    	 
     }
    //генерируем случайный цвет .
     private Color getRndColor() {
    	 
    	 int r = random.nextInt(255);
    	 int g = random.nextInt(255);
    	 int b = random.nextInt(255);
    	 
    	 return new Color(r,g,b);
     }
     
}
