package com.mygdx.game;

import com.badlogic.gdx.ai.msg.Telegram;

public interface INodeBehaviour {
	public void stop();
	public void goToFlags();
	public void startAuction();
	public boolean handleMessage(Telegram msg);
}
