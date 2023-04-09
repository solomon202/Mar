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
import static utilz.Constants.PlayerConstants.*;
//игровая панель где происходит вывод картинок 
public class GamePanel extends JPanel{
	//есть уже заданые параметры или получить через конструктор изменяемые данные .
	private MouseInputs mouseInputs;
	private  float xDelta =100,yDelta = 100;
	private BufferedImage img;
	private BufferedImage[][] animations;
	private int aniTick,aniIndex,aniSpeed = 15;
	private int playerAction = IDLE;

	//связываеп панель с клавай и мышкой 
   public GamePanel() { 
	   
	   //здесь мы создаем экземпляр класса со своими данными точька где мышка 
	   mouseInputs = new MouseInputs(this);  
	   //здесь мы берем методы 
	   importImg();
	   
	   
	   loadAnimations();
	   setPanelSize();
	   // для обработки событий клавиатуры необходимо реализовать специальный интерфейс, а затем добавить получившегося слушателя к интересуемому компоненту. 
	   addKeyListener(new Keyboardsinput(this));
	   //эти интерфейса содержат методы, принимающие и обрабатывающие различные типы событий от мыши
	   addMouseListener(mouseInputs);
	   addMouseMotionListener(mouseInputs);
	   
   }
   //создать буфе из 5 картинок 
   private void loadAnimations() {
	animations = new BufferedImage [9][6];
	
	for(int j = 0; j < animations.length; j++)
	//прогнать по 5 и  втавить вырезаную картинку в массив 
	for (int i = 0 ; i < animations[j].length; i++)
		animations[j][i] = img.getSubimage(i * 64,j * 40, 64, 40);
	
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
	   Dimension size = new Dimension(1200,600);
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
   
   private void updateAnimationTick() {
		//  когда нужно изменить последовательный ход
	   //если это условие выполняется, то срабатывает код
	  aniTick++;
	   if(aniTick >= aniSpeed) {
		   aniTick = 0;
		   aniIndex ++;
		   if(aniIndex >= GetSpriteAmount(playerAction))
			   aniIndex = 0;  
		   
	   } 	
   }
   
   public void paintComponent(Graphics g) {
	   super.paintComponent(g);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
	   
	   updateAnimationTick();
	                                                                                          
	   //получить изображение и вырезать по координатам и размер
	  g.drawImage(animations[playerAction][aniIndex],(int)xDelta,(int)yDelta, 256, 160, null);
	
	  
	   }

	  
     
}
