package com.mygdx.game;

public class Counter {
   
	

	public float timerX;
	public float timerY;
	public float time;
	public float currentTime;
	public int id;
	public boolean stopped=false;
	
	public Counter(){}
	
	
	public Counter(float timerX, float timerY, float time) {
		
		this.timerX = timerX;
		this.timerY = timerY;
		this.time = time;
		
	}

	
	
	public float minusTime(float deltaTime) {
		 if(!stopped) {time -= deltaTime;}
		 return time;
	}

	public float getTimerX() {
		return timerX;
	}


	public void setTimerX(float timerX) {
		this.timerX = timerX;
	}


	public float getTimerY() {
		return timerY;
	}


	public void setTimerY(float timerY) {
		this.timerY = timerY;
	}


	public float getTime() {
		return time;
	}


	public void setTime(float time) {
		this.time = time;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public float getCurrentTime() {
		return currentTime;
	}


	public void setCurrentTime(float currentTime) {
		this.currentTime = currentTime;
	}

}
