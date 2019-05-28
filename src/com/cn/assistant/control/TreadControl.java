package com.cn.assistant.control;

import com.cn.assistant.service.ButtonEventService;
import com.cn.assistant.ui.InsertCommandUI;

/**
 * ���������̵߳ĵ����ַ�ʽ�������������ڲ���
 * @author fatah
 */
public class TreadControl {
    public  void InsertCommandUITread() {
        //��ʽ1���൱�ڼ̳���Thread�࣬��Ϊ������дrun()ʵ��
        Thread thread = new Thread();
        new Thread(thread) {
            @Override
            public void run() {
                if (ButtonEventService.frameState == 0){
                    new InsertCommandUI();
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
    public void ShutDown(){
        Thread.interrupted();
    }
    public static void main(String[] args) {
        TreadControl treadControl = new TreadControl();
        treadControl.InsertCommandUITread();
        treadControl.ShutDown();
    }
}