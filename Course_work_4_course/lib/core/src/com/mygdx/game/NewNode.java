package com.mygdx.game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.msg.MessageDispatcher;
import com.badlogic.gdx.ai.msg.MessageManager;
import com.badlogic.gdx.ai.msg.Telegram;
import com.badlogic.gdx.ai.msg.Telegraph;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

abstract class NewNode extends Actor implements Telegraph{
	     // область видимости на карте
    
	public static MessageDispatcher dispatcher=MessageManager.getInstance();
	public static MessageDispatcher dispatcher2=MessageManager.getInstance();
	protected float flagX;  // координаты флага к которому они идут
    protected float flagY;
	protected float startX;
    protected float startY;
    protected float myXx ;         // текущие координаты
    protected float myYy ;   
    public int id; 
    protected float speedX;        // скорость по х
    protected float speedY;        // скорость по у
    protected float xDestination;  // координаты назначения
    protected float yDestination;
    protected float nextX;         // следующая координата после текущей
    protected float nextY;         // следующая координата после текущей
    protected float speed;         // скорость передвижения
    protected Random rnd;
    protected boolean timeToGo=false; // отсчёт до старта
    protected int destinationFlagIndex=TestGame.flags.size()-1;
    protected float spending;
    protected float price=10.0f;
    
    
    
    abstract void start();
    
    
    Texture texture = new Texture(Gdx.files.internal("node.png"));

	public boolean stoped;
	
	
	public NewNode(){
		 dispatcher.addListener(this, 1);  
		
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public void startAuction(){}
}
