package com.mygdx.game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Button implements ActionListener{
	private int xf;
	private int yf;
	private int i;
	private Random rnd;	
	   Button(String text,int x, int y){
		 //  i=TestGame.nodesList.size();
		   
		// xf=rnd.nextInt(400); 
	    //  yf=rnd.nextInt(400);
	   
		   
		 JFrame window=new JFrame("Выбор модели");  
		  window.setBounds(x, y, 360, 170); 
		  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  JButton but1=new JButton("Простая модель");
		  but1.setBounds(90, 40, 180, 30);
		  but1.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				  TestGame.nodesList.add(new Node1(xf,yf,i));	
				  }
				});
		  JButton but2=new JButton("Модифицированная модель");
		  but2.setBounds(90, 70, 180, 30);
		  but2.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				  TestGame.nodesList.add(new Node2(xf,yf,i));
				  }
				});
		  window.setLayout(null);
		  window.add(but1);
		  window.add(but2);
		  window.setVisible(true);
	   }

	 


	   @Override
		public void actionPerformed(ActionEvent AEobj) {
				
			
		}
	  
	    public static void main(String[] args){
	    	new Button("Выбор модели", 400, 250);
	    }
}
