package com.cn.assistant.control;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseControl extends MouseAdapter {

	private SoftControl softcontrol;
	private Point origin = new Point();

	public MouseControl(SoftControl softcontrol){

		this.softcontrol = softcontrol;

	}

	@Override
	public void mousePressed(MouseEvent e) {
		origin.x = e.getX();
		origin.y = e.getY();
		System.out.println(origin.x+","+origin.y);
		if(origin.x>145 && origin.x<165 && origin.y>210 && origin.y<255 && softcontrol.softtimer.flashid==2){
			//System.out.println("��");
			softcontrol.softdao.behave.startdance();
		}
		else if(origin.x>135 && origin.x<180 && origin.y>92 && origin.y<110 && softcontrol.softtimer.flashid==2){
			//System.out.println("�۾�");
			softcontrol.softdao.behave.startsleep();
		}
		else if(origin.x>125 && origin.x<190 && origin.y>48 && origin.y<65 && softcontrol.softtimer.flashid==2){
			//System.out.println("����");
			softcontrol.softdao.behave.startspeak();
		}
		else if(origin.x>40 && origin.x<80 && origin.y>70 && origin.y<150 && softcontrol.softtimer.flashid==4){
			//System.out.println("��");
			softcontrol.softdao.behave.startwait();
		}
		else if((origin.x>190 || origin.x<125) && origin.y>160 && origin.y<250 && softcontrol.softtimer.flashid==2){
			// System.out.println("ͷ��");
			softcontrol.softdao.behave.startjump();
		}
	}

	/**
	 * ����ƽ�������ʱ���������ͼ��Ϊ�ƶ�ͼ��
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		softcontrol.frame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	/**
	 * ����Ƴ�������ʱ���������ͼ��ΪĬ��ָ��
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		softcontrol.frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

	/**
	 * ����ڱ�������קʱ�����ô��ڵ�����λ��
	 * �����µ�����λ�� = �ƶ�ǰ����λ��+�����ָ�뵱ǰ����-��갴��ʱָ���λ�ã�
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		Point p = softcontrol.frame.getLocation();
		softcontrol.frame.setLocation(
				p.x + (e.getX() - origin.x),
				p.y + (e.getY() - origin.y));
	}
	//�����
	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("x:"+e.getX()+"y"+e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		/*
		 * ��Ϸ����
		 */
		if(e.getX()>170 && e.getY()>140 && e.getX()<170+126*5 && e.getY()<140+126*3){

			//int nowx = (e.getX()-170)/126;							//ת��Ϊ��ͼ����
			//int nowy = (e.getY()-140)/126;							//ת��Ϊ��ͼ����
		}
	}

}
