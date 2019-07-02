package com.cn.assistant.control;

import com.cn.assistant.service.ButtonEventService;
import com.cn.assistant.ui.HintUI;

/**
 * ��Ȼ���ֲ��꣬��������һ���߳��࣬��ߵĶ��Ƕ����ͣ��ʱ����߳̿���
 * @author fatah
 */
public class TreadControl {
    public ButtonEventService buttonEventService;
    public static boolean panelExit = false;
    //�����������������ʾ���ڵ�ͣ��ʱ��
    public  void HintUITread() {
        //��ʽ1���൱�ڼ̳���Thread�࣬��Ϊ������дrun()ʵ��
        Thread thread = new Thread();
        new Thread(thread) {
            @Override
            public void run() {
                try {
                    if (panelExit == ButtonEventService.panelExit) {
                        buttonEventService.test = new HintUI(ButtonEventService.buttonNumber);
                        buttonEventService.jPanel.add(buttonEventService.test);
                        panelExit = true;
                        Thread.sleep(3000);
                        buttonEventService.jPanel.remove(buttonEventService.test);
                        panelExit = false;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
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

    public TreadControl(ButtonEventService buttonEventService) {

        this.buttonEventService = buttonEventService;

    }
}