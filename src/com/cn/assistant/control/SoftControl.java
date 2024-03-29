package com.cn.assistant.control;

import com.cn.assistant.dao.SoftDao;
import com.cn.assistant.entity.Dialog;
import com.cn.assistant.entity.*;
import com.cn.assistant.ui.JFrameSoft;
import com.cn.assistant.ui.JPanelSoft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SoftControl {

	public  JPanelSoft panel;
	public static JFrameSoft frame ;
	public SoftDao softdao ;
	public TimerControl softtimer;

	public Sleep sleep= new Sleep(710,0);
	public Wait wait= new Wait(710,0);
	public Dance dance= new Dance(710,0);
	public Speak speak= new Speak(710,0);
	public Jump jump= new Jump(740,30);
	public com.cn.assistant.entity.Dialog dialog= new Dialog(700,0);

	public SoftControl(){
		// 创建游戏面板
		this.panel = new JPanelSoft(this);
		this.panel.setLayout(null);
		frame = new JFrameSoft(panel);
		frame.setVisible(true);
		frame.setIconImage(SoftIcons.ICON_IMG);
		//添加鼠标事件
		MouseControl mouse = new MouseControl(this);
		frame.addMouseListener(mouse);
		frame.addMouseWheelListener(mouse);
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
			MenuItem mainFrameItem = new MenuItem("main");
			mainFrameItem.addActionListener(listener1);

			//最小化界面
			MenuItem limitFrameItem = new MenuItem("minner");
			limitFrameItem.addActionListener(listener2);

			//退出程序选项
			MenuItem exitItem = new MenuItem("退出");
			exitItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (JOptionPane.showConfirmDialog(null, "确定", " ", JOptionPane.YES_NO_OPTION) == 0) {
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
