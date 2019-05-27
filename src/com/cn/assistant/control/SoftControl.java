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

	public JPanelSoft panel;
	public JFrameSoft frame ;
	public SoftDao softdao ;
	public TimerControl softtimer;

	public Sleep sleep= new Sleep(10,0);
	public Wait wait= new Wait(10,0);
	public Dance dance= new Dance(10,0);
	public Speak speak= new Speak(10,0);
	public Jump jump= new Jump(40,30);
	public com.cn.assistant.entity.Dialog dialog= new Dialog(0,0);

	public SoftControl(){
		// ������Ϸ���
		this.panel = new JPanelSoft(this);
		this.panel.setLayout(null);
        new ButtonControl(panel);
		frame = new JFrameSoft(panel);

		frame.setVisible(true);
		frame.setIconImage(SoftIcons.ICON_IMG);
		//�������¼�
		MouseControl mouse = new MouseControl(this);
		frame.addMouseListener(mouse);
		frame.addMouseWheelListener(mouse);
		frame.addMouseMotionListener(mouse);

		softdao = new SoftDao(this);
		softtimer= new TimerControl(this);
		softtimer.start();

		if (SystemTray.isSupported()) // �ж�ϵͳ�Ƿ�֧��ϵͳ����
		{
			SystemTray tray = SystemTray.getSystemTray(); // ����ϵͳ����


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

			// ���������˵�
			PopupMenu popup = new PopupMenu();

			//������ѡ��
			MenuItem mainFrameItem = new MenuItem("mainframe");
			mainFrameItem.addActionListener(listener1);

			//��С������
			MenuItem limitFrameItem = new MenuItem("minner");
			limitFrameItem.addActionListener(listener2);

			//�˳�����ѡ��
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

			TrayIcon  trayIcon = new TrayIcon(SoftIcons.ICON_IMG, "��լ����", popup);// ����trayIcon
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
