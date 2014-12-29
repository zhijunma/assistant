package com.cn.scnu.assistant.ui;

import java.awt.Color;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class JFrameSoft extends JFrame {

		public JFrameSoft(JPanelSoft panel){
			
			//设置窗体大小
			this.setBounds(1000, 300, 500, 500);
			
			//设置窗体透明
			this.setUndecorated(true);
			this.setBackground(new Color(0,0,0,0));//alpha分量为零
			
			//设置窗体永远在前
			this.setAlwaysOnTop(true);
			
			//设置默认Panel
			this.setContentPane(panel);
			
		}
}
