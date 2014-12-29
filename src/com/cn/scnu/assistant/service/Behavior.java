package com.cn.scnu.assistant.service;

import java.util.Random;

import com.cn.scnu.assistant.control.SoftControl;
import com.cn.scnu.assistant.entity.Say;

public class Behavior {

	private SoftControl softcontrol;
	
	public String word;
	
	public Posthtml imfo;
	
	public Behavior(SoftControl softcontrol){
		this.softcontrol = softcontrol;
		imfo = new Posthtml();
	}
	
	public void startspeak(){
		softcontrol.softtimer.flashid=4;
	    softcontrol.softtimer.frame=10;
	    softcontrol.softtimer.nowframe=0;
	}
	
	public void startdance(){
		softcontrol.softtimer.flashid=3;
  	  	softcontrol.softtimer.frame=73;
  	  	softcontrol.softtimer.nowframe=0;
	}
	
	public void startwait(){
		softcontrol.softtimer.flashid=2;
  	  	softcontrol.softtimer.frame=8;
  	  	softcontrol.softtimer.nowframe=0;
	}
	
	public void startsleep(){
		softcontrol.softtimer.flashid=1;
  	  	softcontrol.softtimer.frame=36;
  	  	softcontrol.softtimer.nowframe=0;
	}
	
	public void wordchange(){
		Random random = new Random();
		if(softcontrol.softtimer.flashid==2)
			word=Say.word[random.nextInt(Say.stringlong)];
		else if(softcontrol.softtimer.flashid==3)
			word="�����úÿ���";
		else if(softcontrol.softtimer.flashid==1)
			word="��˵���һ᷸����";
		else if(softcontrol.softtimer.flashid==4){
			String[] strarray=Posthtml.getDocument("http://www.bilibili.com/video/bangumi.html").split("\n"); 
			String[] film = strarray[random.nextInt(strarray.length)].split(" ");
			word="���£�"+film[1];
		}
	}
	
	
}
