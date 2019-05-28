package com.cn.assistant.ui;

import com.cn.assistant.control.SoftControl;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class JPanelSoft extends JPanel{
	ImageIcon [] img = new ImageIcon[5];
	//创建一组按钮
	JButton [] jButtons = new JButton[5];
	public SoftControl softcontrol;
	int status = 0;
	public JPanelSoft(SoftControl softcontrol){


		this.softcontrol = softcontrol;
		this.setOpaque(false);//设置panel为透明
	}

	@Override
	public void paintComponent(Graphics g){

		softcontrol.sleep.draw(g);
		softcontrol.wait.draw(g);
		softcontrol.dance.draw(g);
		softcontrol.speak.draw(g);
		softcontrol.jump.draw(g);
		if(softcontrol.dialog.say ){
			softcontrol.dialog.draw(g);
			g.drawString(softcontrol.softdao.behave.word, 10, 20);


		}
	}
}
