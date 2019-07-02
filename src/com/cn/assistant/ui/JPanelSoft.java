package com.cn.assistant.ui;

import com.cn.assistant.control.SoftControl;
import com.cn.assistant.service.ButtonEventService;

import javax.swing.*;
import java.awt.*;

/**
 * 主要组件
 */
@SuppressWarnings("serial")
public class JPanelSoft extends JPanel{
	ImageIcon [] img = new ImageIcon[5];
	//创建一组按钮
	JButton [] jButtons = new JButton[5];

	public SoftControl softcontrol;
	public JPanelSoft(SoftControl softcontrol){
		AddPanel();
		this.setLayout(null);
		this.softcontrol = softcontrol;
		this.setOpaque(false);//设置panel为透明
		this.add(jButtons[0]);
		this.add(jButtons[1]);
		this.add(jButtons[2]);
		this.add(jButtons[3]);
		this.add(jButtons[4]);
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
			g.drawString(softcontrol.softdao.behave.word, 710, 20);
		}
	}
	public JButton[] AddPanel(){

		for (int i = 0; i<5 ;i++){
			img[i] = new ImageIcon("image/buttonImage/"+i+".png");
			Image temp = img[i].getImage().getScaledInstance(20,20, img[i].getImage().SCALE_DEFAULT);
			img[i] = new ImageIcon(temp);
		}
		//创建一个带图片样式的按钮
		jButtons[0] = new JButton(img[0]);
		//设置按钮位置，大小
		jButtons[0].setBounds(950,240,20,20);
		//隐藏按钮边框
		jButtons[0].setBorderPainted(false);
		jButtons[0].addActionListener(new ButtonEventService(0,this,softcontrol));
		jButtons[1] = new JButton(img[1]);
		jButtons[1].setBounds(950,210,20,20);
		jButtons[1].setBorderPainted(false);
		jButtons[1].addActionListener(new ButtonEventService(1,this,softcontrol));
		jButtons[2] = new JButton(img[2]);
		jButtons[2].setBounds(950,180,20,20);
		jButtons[2].setBorderPainted(false);
		jButtons[2].addActionListener(new ButtonEventService(2,this,softcontrol));
		jButtons[3] = new JButton(img[3]);
		jButtons[3].setBounds(950,150,20,20);
		jButtons[3].setBorderPainted(false);
		jButtons[3].addActionListener(new ButtonEventService(3,this,softcontrol));
		jButtons[4] = new JButton(img[4]);
		jButtons[4].setBounds(950,120,20,20);
		jButtons[4].setBorderPainted(false);
		jButtons[4].addActionListener(new ButtonEventService(4,this,softcontrol));
		return jButtons;
	}
}
