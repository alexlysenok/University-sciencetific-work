package com.mygdx.game;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

abstract class Node extends Actor{
	private final int privDistance = 5;
	  
    Texture texture = new Texture(Gdx.files.internal("Node3.png"));
    protected float myXx ;                   // ��������� ����������
    protected float myYy ;   
    protected int id; 
    protected float speedX;        // �������� �� �
    protected float speedY;
    protected float xDestination;  // ���������� ����������
    protected float yDestination;
    protected float nextX;         // ��������� ���������� ���� �������
    protected float nextY;         // ��������� ���������� ���� �������
    protected float speed;         // �������� ������������
    protected Random rnd;
    public boolean stoped;
    protected boolean evading;
    protected boolean danger;
    protected boolean ghostModeOn;	
    protected SpriteBatch spriteBatch;
    protected Timer timer;
    protected TimerTask timertask;
    Texture texture2 = new Texture(Gdx.files.internal("les.png"));
    protected int neighbours=0;
    protected static float radius=125;
}
