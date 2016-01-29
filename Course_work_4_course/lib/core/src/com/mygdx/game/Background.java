package com.mygdx.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Background extends Actor {
	
    	Texture background;
    	Background(Texture tmp){
    		background=tmp;
    	}
    	@Override

    	public void draw(Batch batch,float ParentAlpha){
    	batch.draw(background, 0, 0);
    	}
		
    	
}
