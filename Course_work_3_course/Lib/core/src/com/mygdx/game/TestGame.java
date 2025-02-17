package com.mygdx.game;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class TestGame implements ApplicationListener {
	
	  private int trueTact=0;
	    private SpriteBatch Batch;
	    SpriteBatch batch; 
	    DataStreamer dataStreamer = new DataStreamer();
	    private Texture texture2 ;
		private Random rnd;
	    private Stage stage;
	    public static ArrayList<Node> nodesList=new ArrayList<Node>();
	    static int nodesNumber=Integer.parseInt(JOptionPane.showInputDialog("������� ���-�� �����:"));
	    public static int density=(Integer.parseInt(JOptionPane.showInputDialog("������� ��������� �����:"))-1);
	    Timer timer = new Timer();
	    Timer timer2 = new Timer();
		private Graph graphs;
	    @Override
	    public void create() { 
	    	rnd=new Random();
	    

	    	
	    	batch = new SpriteBatch();
	    	texture2 = new Texture(Gdx.files.internal("les.png"));
	    	Background back = new Background(texture2);
	    	
	    	stage = new Stage();
	    	stage.addActor(back);

	        int x;
	        int y;
	        boolean xLeft;
	        boolean yTop;
	        	
	        Gdx.input.setInputProcessor(stage);
	     	   for(int i=0;i<nodesNumber;i++)
	     	   {
	     		 xLeft=rnd.nextBoolean();
	     	     yTop=rnd.nextBoolean();
	     		  if(xLeft==true)
	     	        {
	     			  x=rnd.nextInt(400);
	     	        }
	     		  else x=rnd.nextInt(400)+624;
	     		 
	     		  if(yTop==true)
	  	        {
	  			  y=rnd.nextInt(400);
	  	        }
	  		  else y=rnd.nextInt(400)+624;
	    // new Button("����� ������", 400, 250);
	     		 nodesList.add(new Node1(x,y,i));   
	     		 stage.addActor(nodesList.get(i));
	     	   }
	     	  
	     	
	     	  
	     	 
	     	 timer.scheduleAtFixedRate(new TimerTask() {
	     		  @Override
	     		  public void run() {
	     			 trueTact++;
	     			 if(trueTact<=10)
	     			 {  
	     		      dataStreamer.scanData(trueTact);
	     	     	  
	     	      }else trueTact=0;
	     		  }
	     		}, 50, 400);  
	     	 
	     	 
	     	graphs= new Graph();
	     	 
	     	timer2.scheduleAtFixedRate(new TimerTask() {
	   		  @Override
	   		  public void run() {
	              graphs.smatrix();
	            

	          	for(int i = 0; i < TestGame.nodesList.size(); i++) 
	          		{
	          		      System.out.print("\n");
	          		      for(int j = 0; j < TestGame.nodesList.size(); j++)
	          		      {
	                          System.out.print(graphs.smatrix[i][j]);                      
	          		      }   
	          		}
	          	System.out.print("\n"+"\n");
	            System.out.print("Nodes alone: " + graphs.getAloneNodesNumber());

	   		  }
	   		}, 4000, 2000);
	    }
	    
	    
	    
	    
	    
	    
	    

	    @Override
	    public void dispose() {
	    	
	    }

	    @Override
	public void render() {    
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    Gdx.gl.glClearColor(0, 0, 0, 1);
	    
	   batch.begin();
	    stage.act(Gdx.graphics.getDeltaTime());
	    stage.draw();
	   batch.end();
	}

	    @Override
	    public void resize(int width, int height) {
	    	//stage.setViewport(1024, 720, true);
	    }

	    @Override
	    public void pause() {
	    }

	    @Override
	    public void resume() {
	    }
}
