package com.cn.scnu.assistant.ui;

import java.awt.Color;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class JFrameSoft extends JFrame {

		public JFrameSoft(JPanelSoft panel){
			
			//���ô����С
			this.setBounds(1000, 300, 500, 500);
			
			//���ô���͸��
			this.setUndecorated(true);
			this.setBackground(new Color(0,0,0,0));//alpha����Ϊ��
			
			//���ô�����Զ��ǰ
			this.setAlwaysOnTop(true);
			
			//����Ĭ��Panel
			this.setContentPane(panel);
			
		}
}
