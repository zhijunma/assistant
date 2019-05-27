package java.com.cn.assistant.service;

import java.com.cn.assistant.control.SoftControl;
import java.com.cn.assistant.entity.Say;

import java.util.Random;

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

	public void startjump(){
		softcontrol.softtimer.flashid=5;
		softcontrol.softtimer.frame=8;
		softcontrol.softtimer.nowframe=0;
	}

	public void wordchange(){
		Random random = new Random();
		if(softcontrol.softtimer.flashid==2)
			word=Say.word[random.nextInt(Say.stringlong)];
		else if(softcontrol.softtimer.flashid==3)
			word="我跳得好看吗";
		else if(softcontrol.softtimer.flashid==1)
			word="都说淫家会犯困的";
		else if(softcontrol.softtimer.flashid==4){
			String[] strarray=Posthtml.getDocument("http://www.bilibili.com/video/bangumi.html").split("\n");
			String[] film = strarray[random.nextInt(strarray.length)].split(" ");
			word="更新："+film[1];
		}
	}


}
