package com.cn.assistant.entity;

import java.awt.Graphics;

public class Dialog {


	protected static final int RECTW = 150;

	protected static final int RECTH = 80;

	public int x ;

	public int y ;

	public boolean say = false;

	public Dialog(int x,int y){

		this.x=x;
		this.y=y;

	}

	public void draw(Graphics g){

		if(say) {
			g.drawImage(SoftIcons.DIALOG_IMG2 ,x , y, null);
		}

	}
}
