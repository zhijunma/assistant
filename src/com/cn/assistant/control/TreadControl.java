package com.cn.assistant.control;

import com.cn.assistant.service.ButtonEventService;

import javax.swing.*;

/**
 * ���������̵߳ĵ����ַ�ʽ�������������ڲ���
 * @author fatah
 */
public class TreadControl {
    public JPanel jPanel;
    public ButtonEventService buttonEventService;
    public  void InsertCommandUITread() {
        //��ʽ1���൱�ڼ̳���Thread�࣬��Ϊ������дrun()ʵ��
        Thread thread = new Thread();
        new Thread(thread) {
            @Override
            public void run() {
                if (ButtonEventService.frameState == 0){
                    buttonEventService.setCommadFrame();
                    jPanel.add(buttonEventService.jt);
                }
            };
        }.start();
//
//
//        //��ʽ2:ʵ��Runnable,Runnable��Ϊ�����ڲ���
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("�����ڲ��ഴ���̷߳�ʽ2...");
//            }
//        } ).start();
    }

    public TreadControl(JPanel jPanel,ButtonEventService buttonEventService) {
        this.jPanel = jPanel;
        this.buttonEventService = buttonEventService;

    }
}