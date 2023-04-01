package game.Mar.Enter;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import game.Mar.inputs.Keyboardsinput;
import game.Mar.inputs.MouseInputs;
//игровая панель где происходит вывод картинок 
public class GamePanel extends JPanel{
	//есть уже заданые параметры или получить через конструктор изменяемые данные .
	private MouseInputs mouseInputs;
	private  float xDelta =100,yDelta = 100;
	private BufferedImage img,subImg;
	

	//связываеп панель с клавай и мышкой 
   public GamePanel() { 
	   
	   //здесь мы создаем экземпляр класса со своими данными точька где мышка 
	   mouseInputs = new MouseInputs(this);  
	   //здесь мы берем методы 
	   importImg();
	   setPanelSize();
	   // для обработки событий клавиатуры необходимо реализовать специальный интерфейс, а затем добавить получившегося слушателя к интересуемому компоненту. 
	   addKeyListener(new Keyboardsinput(this));
	   //эти интерфейса содержат методы, принимающие и обрабатывающие различные типы событий от мыши
	   addMouseListener(mouseInputs);
	   addMouseMotionListener(mouseInputs);
	   
   }
   
   private void importImg() {
   InputStream is = getClass().getResourceAsStream("/player_sprites.png");
	
   try {
	   img = ImageIO.read(is);
   }catch(IOException e ) {
	   e.printStackTrace();
   }
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
   //связь кнопки и картинки 
   public void changeYDelta(int value) {
	   this.yDelta += value;
	   
   }
   //связывае мышку и картинку 
   public void setRectPos(int x,int y) {
	   this.xDelta = x;
	   this.yDelta = y;
	   
   }
   
   public void paintComponent(Graphics g) {
	   super.paintComponent(g);
	   //получить изображение и вырезать по координатам и размер
	   subImg = img.getSubimage(1*64, 8*40, 64, 40);
	   g.drawImage(subImg,(int)xDelta,(int)yDelta, 128, 80, null);
	
	   }
	  
     
}
