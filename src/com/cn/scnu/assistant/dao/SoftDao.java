package com.cn.scnu.assistant.dao;

import com.cn.scnu.assistant.control.SoftControl;
import com.cn.scnu.assistant.service.Behavior;

public class SoftDao {

	public Behavior behave ;
	
	public SoftControl softcontrol;

	
	public SoftDao(SoftControl softcontrol){
		this.softcontrol = softcontrol;
		behave = new Behavior(softcontrol);
	}

}
