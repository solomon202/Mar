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
import static utilz.Constants.Directions.*;
//игровая панель где происходит вывод картинок 
public class GamePanel extends JPanel{
	//есть уже заданые параметры или получить через конструктор изменяемые данные .
	private MouseInputs mouseInputs;
	private  float xDelta =100,yDelta = 100;
	private BufferedImage img;
	private BufferedImage[][] animations;
	private int aniTick,aniIndex,aniSpeed = 15;
	private int playerAction = IDLE;
	private int playerDir = -1;
	private boolean moving = false;

	//связываеп панель с клавай и мышкой 
	//и  запускаем первыми методы 
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
 //получить картинку 
 private void importImg() {
   InputStream is = getClass().getResourceAsStream("/player_sprites.png");
	
   try {
	   img = ImageIO.read(is);
   }catch(IOException e ) {
	   e.printStackTrace();
   }
}
 //размер панэли 
  private void setPanelSize() {
	   Dimension size = new Dimension(1200,600);
	   setMinimumSize(size);
	   setPreferredSize(size);
	   setMaximumSize(size);
	   
   }
   // направление 
  public void setDirection(int direction) {
	 this.playerDir = direction;
	 moving = true;
	 
 }
   //движение 
 public void setMoving(boolean moving) {
	 this.moving = moving;
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
   private void setAnimation() {
	   if(moving)
		   playerAction = RUNNING;
	   else
		   playerAction = IDLE;
   }
   
   private void updatePos() {
	    if(moving) {
	    	switch(playerDir) {
	    	case LIFT:
	    	xDelta -=5;
	    	break;
	    	case UP:
	    		yDelta -=5;
	    		break;
	    	case RIGHT:
	    		xDelta +=5;
	    		break;
	    	case DOWN:
	    		yDelta +=5;
	    		break;
	    	}
	    }
   }
   
   public void updateGame() {
	   
	   updateAnimationTick();
	   setAnimation();
	   updatePos();
	   
   }
   
   
   public void paintComponent(Graphics g) {
	   super.paintComponent(g);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
	   
	   updateAnimationTick();
	   setAnimation();
	   updatePos();
	                                                                                          
	   //получить изображение и вырезать по координатам и размер
	  g.drawImage(animations[playerAction][aniIndex],(int)xDelta,(int)yDelta, 256, 160, null);
	
	  
	   }
 
}
