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
	

	//связываеп панель с клавай и мышкой 
	//и  запускаем первыми методы 
    public GamePanel() { 
	   
	   //здесь мы создаем экземпляр класса со своими данными точька где мышка 
	   mouseInputs = new MouseInputs(this);  
	
	   setPanelSize();
	   // для обработки событий клавиатуры необходимо реализовать специальный интерфейс, а затем добавить получившегося слушателя к интересуемому компоненту. 
	   addKeyListener(new Keyboardsinput(this));
	   //эти интерфейса содержат методы, принимающие и обрабатывающие различные типы событий от мыши
	   addMouseListener(mouseInputs);
	   addMouseMotionListener(mouseInputs);
	   
   }
   //создать буфе из 5 картинок 


 //размер панэли 
  private void setPanelSize() {
	   Dimension size = new Dimension(1200,600);
	   setPreferredSize(size); 
   }

 

   public void updateGame() {
	    
   }
	   
   public void paintComponent(Graphics g) {
	   super.paintComponent(g);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
	   

	   }
}
