package com.mygdx.game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Background extends Actor{
	Texture texture2;
	Background(Texture tmp){
	texture2=tmp;
	}
	@Override

	public void draw(Batch batch,float ParentAlpha){
	batch.draw(texture2, 0, 0);
	}

}
