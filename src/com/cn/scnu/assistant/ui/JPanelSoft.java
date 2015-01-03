package com.cn.scnu.assistant.ui;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.cn.scnu.assistant.control.SoftControl;

@SuppressWarnings("serial")
public class JPanelSoft extends JPanel{
	
	public SoftControl softcontrol;
	
	public JPanelSoft(SoftControl softcontrol){
		
		this.softcontrol = softcontrol;
		this.setOpaque(false);//ÉèÖÃpanelÎªÍ¸Ã÷
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
