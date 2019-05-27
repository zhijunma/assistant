package java.com.cn.assistant.entity;

import java.awt.Graphics;

public class Dance {

	protected static final int RECTW = 300;

	protected static final int RECTH = 300;

	public int x ;

	public int y ;

	public int frame = 0;

	public SoftIcons icons = new SoftIcons();

	public Dance(int x,int y){

		this.x=x;
		this.y=y;

	}

	public void draw(Graphics g){

		g.drawImage(icons.DANCE_IMG[frame], x , y, null);

	}
}
