package game.Mar.Enter;

import java.awt.Dimension;
import java.awt.Graphics;


import javax.swing.JPanel;

import game.Mar.inputs.Keyboardsinput;
import game.Mar.inputs.MouseInputs;

public class GamePanel extends JPanel{
	//есть уже заданые параметры или получить через конструктор изменяемые данные .
	private MouseInputs mouseInputs;
	private  float xDelta =100,yDelta = 100;
	

	
   public GamePanel() { 
	   
	   
	   mouseInputs = new MouseInputs(this);  
	   setPanelSize();
	   // для обработки событий клавиатуры необходимо реализовать специальный интерфейс, а затем добавить получившегося слушателя к интересуемому компоненту. 
	   addKeyListener(new Keyboardsinput(this));
	   //эти интерфейса содержат методы, принимающие и обрабатывающие различные типы событий от мыши
	   addMouseListener(mouseInputs);
	   addMouseMotionListener(mouseInputs);
	   
   }
   
   private void setPanelSize() {
	   Dimension size = new Dimension(1200,800);
	   setMinimumSize(size);
	   setPreferredSize(size);
	   setMaximumSize(size);
	   
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
	
	   }
	  
     
}
