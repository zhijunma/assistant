package com.cn.scnu.assistant.ui;

import com.cn.scnu.assistant.control.ButtonControl1;
import com.cn.scnu.assistant.control.SoftControl;

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
		ButtonControl1 buttonControl1 = new ButtonControl1();
//		/*获取按钮样式图片，并且让图片适应按钮大小*/
//		for (int i = 0; i<5 ;i++){
//			img[i] = new ImageIcon("image/buttonImage/"+i+".png");
//			Image temp = img[i].getImage().getScaledInstance(20,20, img[i].getImage().SCALE_DEFAULT);
//			img[i] = new ImageIcon(temp);
//		}
//		//创建一个带图片样式的按钮
//		jButtons[1] = new JButton(img[0]);
//		//设置按钮位置，大小
//		jButtons[1].setBounds(250,240,20,20);
//		//隐藏按钮边框
//		jButtons[1].setBorderPainted(false);
////		setIcon(img[1],jButtons[1]);
//		jButtons[2] = new JButton(img[1]);
//		jButtons[2].setBounds(250,210,20,20);
//		jButtons[2].setBorderPainted(false);
//		jButtons[3] = new JButton(img[2]);
//		jButtons[3].setBounds(250,180,20,20);
//		jButtons[3].setBorderPainted(false);
//		jButtons[4] = new JButton(img[3]);
//		jButtons[4].setBounds(250,150,20,20);
//		jButtons[4].setBorderPainted(false);
//		jButtons[0] = new JButton(img[4]);
//		jButtons[0].setBounds(250,120,20,20);
//		jButtons[0].setBorderPainted(false);
//		this.add(jButtons[0]);
//		this.add(jButtons[1]);
//		this.add(jButtons[2]);
//		this.add(jButtons[3]);
//		this.add(jButtons[4]);
//		jButtons[1].addActionListener(buttonControl1);
//		//响应退出按钮
//		jButtons[0].addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				//关闭弹窗
//				status = 1;
//			}
//		});
		if(softcontrol.dialog.say ){
			softcontrol.dialog.draw(g);
			g.drawString(softcontrol.softdao.behave.word, 10, 20);


		}
	}
}
