package com.cn.scnu.assistant.control;

import com.cn.scnu.assistant.dao.SoftDao;
import com.cn.scnu.assistant.entity.Dialog;
import com.cn.scnu.assistant.entity.*;
import com.cn.scnu.assistant.ui.JFrameSoft;
import com.cn.scnu.assistant.ui.JPanelSoft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SoftControl {

	public JPanelSoft panel;
	public JFrameSoft frame ;

	public SoftDao softdao ;

	public TimerControl softtimer;

	public Sleep sleep= new Sleep(10,0);
	public Wait wait= new Wait(10,0);
	public Dance dance= new Dance(10,0);
	public Speak speak= new Speak(10,0);
	public Jump jump= new Jump(40,30);
	public Dialog dialog= new Dialog(0,0);
	ImageIcon [] img = new ImageIcon[5];
	//创建一组按钮
	JButton [] jButtons = new JButton[5];
	public SoftControl(){

		// 创建游戏面板
		this.panel = new JPanelSoft(this);

		// 创建游戏窗口
		frame = new JFrameSoft(panel);
		for (int i = 0; i<5 ;i++){
			img[i] = new ImageIcon("image/buttonImage/"+i+".png");
			Image temp = img[i].getImage().getScaledInstance(20,20, img[i].getImage().SCALE_DEFAULT);
			img[i] = new ImageIcon(temp);
		}
		//创建一个带图片样式的按钮
		jButtons[0] = new JButton(img[0]);
		//设置按钮位置，大小
		jButtons[0].setBounds(250,240,20,20);
		//隐藏按钮边框
		jButtons[0].setBorderPainted(false);
//		setIcon(img[1],jButtons[1]);
		jButtons[1] = new JButton(img[1]);
		jButtons[1].setBounds(250,210,20,20);
		jButtons[1].setBorderPainted(false);
		jButtons[2] = new JButton(img[2]);
//		jButtons[2].setBounds(250,180,30,30);
		jButtons[2].setBorderPainted(false);
		jButtons[3] = new JButton(img[3]);
		jButtons[3].setBounds(250,150,20,20);
		jButtons[3].setBorderPainted(false);
		jButtons[4] = new JButton(img[4]);
		jButtons[4].setBounds(250,120,20,20);
		jButtons[4].setBorderPainted(false);
//		frame.add(jButtons[0]);
//		frame.add(jButtons[1]);
		frame.add(jButtons[2]);
//		frame.add(jButtons[3]);
//		frame.add(jButtons[4]);
		frame.setVisible(true);
		frame.setIconImage(SoftIcons.ICON_IMG);
		//添加鼠标事件
		MouseControl mouse = new MouseControl(this);
		frame.addMouseListener(mouse);
		frame.addMouseMotionListener(mouse);

		softdao = new SoftDao(this);
		softtimer= new TimerControl(this);
		softtimer.start();

		if (SystemTray.isSupported()) // 判断系统是否支持系统托盘
		{
			SystemTray tray = SystemTray.getSystemTray(); // 创建系统托盘


			ActionListener listener1 = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(true);
				}
			};
			ActionListener listener2 = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
				}
			};

			// 创建弹出菜单
			PopupMenu popup = new PopupMenu();

			//主界面选项
			MenuItem mainFrameItem = new MenuItem("mainframe");
			mainFrameItem.addActionListener(listener1);

			//最小化界面
			MenuItem limitFrameItem = new MenuItem("minner");
			limitFrameItem.addActionListener(listener2);

			//退出程序选项
			MenuItem exitItem = new MenuItem("exit");
			exitItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (JOptionPane.showConfirmDialog(null, "yes or no", " ", JOptionPane.YES_NO_OPTION) == 0) {
						System.exit(0);
					}
				}
			});

			popup.add(mainFrameItem);
			popup.add(limitFrameItem);
			popup.add(exitItem);

			TrayIcon  trayIcon = new TrayIcon(SoftIcons.ICON_IMG, "漫宅助手", popup);// 创建trayIcon
			trayIcon.addActionListener(listener1);
			trayIcon.addActionListener(listener2);
			try {
				tray.add(trayIcon);
			} catch (AWTException e1) {
				e1.printStackTrace();
			}
		}
	}


}
