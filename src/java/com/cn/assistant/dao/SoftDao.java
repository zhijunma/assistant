package java.com.cn.assistant.dao;

import java.com.cn.assistant.control.SoftControl;
import java.com.cn.assistant.service.Behavior;

public class SoftDao {

	public Behavior behave ;

	public SoftControl softcontrol;


	public SoftDao(SoftControl softcontrol){
		this.softcontrol = softcontrol;
		behave = new Behavior(softcontrol);
	}

}
