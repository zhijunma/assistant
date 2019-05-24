package com.cn.scnu.assistant.entity;

import java.awt.Graphics;

public class Sleep {

	protected static final int RECTW = 300;

	protected static final int RECTH = 300;

	public int x ;

	public int y ;

	public int frame = 0;

	public SoftIcons icons = new SoftIcons();

	public Sleep(int x,int y){

		this.x=x;
		this.y=y;

	}

	public void draw(Graphics g){

		g.drawImage(icons.SLEEP_IMG[frame], x+50 , y+100, 200,200,null);

	}
}
