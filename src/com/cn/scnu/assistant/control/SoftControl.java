package com.cn.scnu.assistant.control;

import com.cn.scnu.assistant.dao.SoftDao;
import com.cn.scnu.assistant.entity.Dance;
import com.cn.scnu.assistant.entity.Dialog;
import com.cn.scnu.assistant.entity.Sleep;
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
	public Dialog dialog= new Dialog(0,0);
	
	public SoftControl(){
		
		// 创建游戏面板
		this.panel = new JPanelSoft(this);
		
		// 创建游戏窗口
	    frame = new JFrameSoft(panel);
		frame.setVisible(true);	
		
		//添加鼠标事件
		MouseControl mouse = new MouseControl(this);
		frame.addMouseListener(mouse);
		frame.addMouseMotionListener(mouse);
		
		softdao = new SoftDao(this);
		softtimer= new TimerControl(this);
		softtimer.start();
	}


}
