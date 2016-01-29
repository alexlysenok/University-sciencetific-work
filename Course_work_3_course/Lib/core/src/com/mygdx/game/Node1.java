package com.mygdx.game;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Node1 extends Node{
private final int privDistance = 5;
  
    public Node1(float startX, float startY, int pId){
    	rnd=new Random();
    	initRandomValues();
    	stoped=false;
    	evading = false;
    	myXx=startX;
    	myYy=startY;
    	id = pId;
    	danger=false;
    	ghostModeOn = false;
    	
    	timer = new Timer();
    	
    	timertask =new TimerTask(){
				@Override
				public void run() {	
					if(!ghostModeOn) {
						if(!danger) {
							if (stoped==true) {
								danger=true;
						    //timer2.schedule(timertask2, 500);
							}	
						} else {
							danger = false;
							stoped = false;
							ghostModeOn = true;
						}
					} else {
						ghostModeOn = false;
					}
					
				}
		};   
 
		
				 timer.scheduleAtFixedRate(timertask, 1, 500);

       }
    
    
    
   @Override
    public void draw(Batch batch, float alpha){
    	
    	batch.draw(texture,myXx,myYy);
    	
    }
    
    public void printSpeed()   //вывод скорости
	{
		speed=(float)Math.hypot(speedX, speedY);    //   вычисление скорости
		 System.out.println("speed: "+speed);
	}
    @Override
    public void act(float delta){
       
            //myX+=speedX;
            //myY+=speedY;
    	
    	
    	if(myXx>xDestination)        //  перемещение по х
		 {	 
			 nextX=myXx-speedX;
		 }else if(myXx<xDestination)   //  перемещение по х
		 {					 
			 nextX=myXx+speedX;
		 }
		 if(myYy>yDestination)       //   перемещение по у
		 {					
			 nextY=myYy-speedY;
		 }else if(myYy<yDestination)      //   перемещение по у
		 {					
			 nextY=myYy+speedY;
		 }
		 
		 
		 lookAround(nextX, nextY);
		 
		 
		 
		 if(!stoped && evading) {
			 if(rnd.nextBoolean()) {
			 myXx=nextX;
			 } else {
				 myYy=nextY;

			 }
		 }
		 if(stoped) {
			 if(canIMoveAgain()) {
				 stoped = false;
			 }
		 }
		 
		 if(evading) {
			 if(canIStopEvading()) {
				 evading = false;
			 }
		 }
		 
		 if(!stoped && !evading || ghostModeOn)        // перемещение на след. позицию, если она свободна
		 {
			 myXx=nextX;
			 myYy=nextY;  
		 }
		  
		// System.out.print(" x=" + myXx + "  y=" + myYy + "||");         
		//printSpeed();
		
	 if (Math.abs(myXx-xDestination)<speedX && Math.abs(myYy-yDestination)<speedY)
		 {
			 initRandomValues();						 
		 }	
        
   }
    public void initRandomValues()   // инициализация значений
	{
		xDestination=rnd.nextInt(1000);
		yDestination=rnd.nextInt(1000);
		speedX= rnd.nextFloat()/2 + 0.5f;
		speedY=speedX;	
	//	System.out.println("номер узла: "+ id + "\n" + "место назначения: " + "x:" + xDestination + " y:" + yDestination + "\n" + "текущее положение: ");
		//System.out.println(" x=" + myXx + "  y=" + myYy);
		
		
	}
	
    
    private void lookAround(float nextX, float nextY) {
    	
    	for (int i=0;i<TestGame.nodesList.size();i++)
		{	
		 if(TestGame.nodesList.get(i).id!=id)       // проверка на сопадение айдишника
		 {
			
			 if (Math.abs((int)(TestGame.nodesList.get(i).myXx-myXx))<privDistance && Math.abs((int)(TestGame.nodesList.get(i).myYy-myYy)) <privDistance)   // проверка на совпадение координат
		     {			  
				 if(TestGame.nodesList.get(i).stoped) {
					 evading = true;
				 } else {
					 stoped = true;
					//if (danger==true)
					// { timertask.cancel();
					// timertask2.cancel();}
					 //timer.schedule(timertask, 500);
				 }
		     }
		 } 				 
		}
	}

    private boolean canIMoveAgain() {
    	for (int i=0;i<TestGame.nodesList.size();i++)
    	{	
    		if(TestGame.nodesList.get(i).id!=id)       // проверка на сопадение айдишника
    		{
    			if (Math.abs((int)(TestGame.nodesList.get(i).myXx-myXx))<privDistance && Math.abs((int)(TestGame.nodesList.get(i).myYy-myYy)) <privDistance)   // проверка на совпадение координат
    			{			  
    				if(TestGame.nodesList.get(i).stoped) {
    					return true;
    				} else {
    					return false;
    				}
    			}
    		} 				 
    	}
    	return true;
    }

    private boolean canIStopEvading() {
     	for (int i=0;i<TestGame.nodesList.size();i++)
    		{	
    		 if(TestGame.nodesList.get(i).id!=id)       // проверка на сопадение айдишника
    		 {
    			 if (Math.abs((int)(TestGame.nodesList.get(i).myXx-myXx))<privDistance && Math.abs((int)(TestGame.nodesList.get(i).myYy-myYy)) <privDistance)   // проверка на совпадение координат
    		     {			  
    				return false;
    		     }
    		 } 				 
    		}
     	return true;
    }
    
    
	private boolean isNextYFree(float nextY) {
		for (int i=0;i<TestGame.nodesList.size();i++)
		{	
		 if(TestGame.nodesList.get(i).id!=id)       // проверка на сопадение айдишника
		 {
			 
			 if (Math.abs((int)(TestGame.nodesList.get(i).myYy-myYy)) <privDistance)    // проверка на совпадение координат
		     {				 
			 return false;		 
		     }			 
		 } 		 				 
	    }
		return true;
	}


	private boolean isNextXFree(float nextX) {
		for (int i=0;i<TestGame.nodesList.size();i++)
		{	
		 if(TestGame.nodesList.get(i).id!=id)       // проверка на сопадение айдишника
		 {
			
			 if (Math.abs((int)(TestGame.nodesList.get(i).myXx-myXx))<privDistance)   // проверка на совпадение координат
		     {			  
			 return false;
		     }
		 } 				 
	    }
		return true;
	}


	
}
