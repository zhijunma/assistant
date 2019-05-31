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
//		System.out.println(origin.x+","+origin.y);
		if(origin.x>845 && origin.x<910 && origin.y>210 && origin.y<255 && softcontrol.softtimer.flashid==2){
			System.out.println("��");
//			softcontrol.softdao.behave.startdance();
		}
		else if(origin.x>835 && origin.x<880 && origin.y>92 && origin.y<110 && softcontrol.softtimer.flashid==2){
			System.out.println("�۾�");
//			softcontrol.softdao.behave.startsleep();
		}
		else if(origin.x>825 && origin.x<890 && origin.y>48 && origin.y<65 && softcontrol.softtimer.flashid==2){
			System.out.println("����");
//			softcontrol.softdao.behave.startspeak();
		}
		else if(origin.x>740 && origin.x<780 && origin.y>770 && origin.y<850 && softcontrol.softtimer.flashid==4){
			System.out.println("��");
//			softcontrol.softdao.behave.startwait();
		}
		else if((origin.x>890 || origin.x<825) && origin.y>860 && origin.y<950 && softcontrol.softtimer.flashid==2){
			 System.out.println("ͷ��");
//			softcontrol.softdao.behave.startjump();
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
//		System.out.println("x:"+e.getX()+"y"+e.getY());
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
