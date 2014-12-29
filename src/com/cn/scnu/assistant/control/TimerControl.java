package com.cn.scnu.assistant.control;

public class TimerControl {

	private Thread sleeptimer;
	
	private Thread saytimer;
	
	private SoftControl softcontrol;
	
	public int frame = 8;
	
	public int flashid = 2;
	
	public int nowframe;
	
	public TimerControl(SoftControl softcontrol){
		
		this.softcontrol = softcontrol;
		
	}
	

	public void start(){
		sleeptimer = new Thread(){
		public void run(){
			for(;;){
				for(nowframe=1;nowframe<frame;nowframe++){
					try {
						if(flashid==2)Thread.sleep(150);
						else Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					softcontrol.sleep.frame=0;
					softcontrol.wait.frame=0;
					softcontrol.dance.frame=0;
					softcontrol.speak.frame=0;
					switch(flashid){
						case 1:softcontrol.sleep.frame=nowframe;break;
						case 2:softcontrol.wait.frame=nowframe;break;
						case 3:softcontrol.dance.frame=nowframe;break;
						case 4:softcontrol.speak.frame=nowframe;break;
					}
					softcontrol.panel.repaint();
				}
				if(flashid == 3 || flashid ==1){
					softcontrol.softdao.behave.startwait();
				}
				softcontrol.sleep.frame=0;
				softcontrol.panel.repaint();
				try {
					Thread.sleep(1000);
			
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		};
		
		saytimer = new Thread(){
			public void run(){
				for(;;){
					if(flashid==2) softcontrol.dialog.say = !softcontrol.dialog.say;
					else softcontrol.dialog.say=true;
					softcontrol.softdao.behave.wordchange();
					try {
						if(flashid==2) Thread.sleep(10000);
						else Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			};
			
		sleeptimer.start();
		saytimer.start();
	}
}
