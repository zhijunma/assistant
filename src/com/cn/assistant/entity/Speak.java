package com.cn.assistant.entity;

import java.awt.Graphics;

public class Speak {

	protected static final int RECTW = 300;

	protected static final int RECTH = 300;

	public int x ;

	public int y ;

	public int frame = 0;

	public SoftIcons icons = new SoftIcons();

	public Speak(int x,int y){

		this.x=x;
		this.y=y;

	}

	public void draw(Graphics g){

		g.drawImage(icons.SPEAK_IMG[frame], x , y, null);

	}
}
