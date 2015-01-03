package com.cn.scnu.assistant.control;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.cn.scnu.assistant.dao.SoftDao;
import com.cn.scnu.assistant.entity.Dance;
import com.cn.scnu.assistant.entity.Dialog;
import com.cn.scnu.assistant.entity.Jump;
import com.cn.scnu.assistant.entity.Sleep;
import com.cn.scnu.assistant.entity.SoftIcons;
import com.cn.scnu.assistant.entity.Speak;
import com.cn.scnu.assistant.entity.Wait;
import com.cn.scnu.assistant.ui.JFrameSoft;
import com.cn.scnu.assistant.ui.JPanelSoft;

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
	
	public SoftControl(){
		
		// 创建游戏面板
		this.panel = new JPanelSoft(this);
		
		// 创建游戏窗口
	    frame = new JFrameSoft(panel);
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
				   public void actionPerformed(ActionEvent e) {
					   frame.setVisible(true);	
				   }	    
			   };
			   ActionListener listener2 = new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				    	frame.setVisible(false);	
				    }	    
			   };	
			   
			   // 创建弹出菜单
			   PopupMenu popup = new PopupMenu();
			   
			   //主界面选项
			   MenuItem mainFrameItem = new MenuItem("主界面");
			   mainFrameItem.addActionListener(listener1);
			   
			   //最小化界面
			   MenuItem limitFrameItem = new MenuItem("最小化");
			   limitFrameItem.addActionListener(listener2);
			   
			 //退出程序选项
			   MenuItem exitItem = new MenuItem("退出程序");
			   exitItem.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			     if (JOptionPane.showConfirmDialog(null, "确定退出系统", "漫宅助手", JOptionPane.YES_NO_OPTION) == 0) {
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
