package com.cn.assistant.control;

import com.cn.assistant.service.ButtonEventService;

import javax.swing.*;

/**
 * 创建启动线程的第三种方式————匿名内部类
 * @author fatah
 */
public class TreadControl {
    public JPanel jPanel;
    public ButtonEventService buttonEventService;
    public  void InsertCommandUITread() {
        //方式1：相当于继承了Thread类，作为子类重写run()实现
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
//        //方式2:实现Runnable,Runnable作为匿名内部类
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("匿名内部类创建线程方式2...");
//            }
//        } ).start();
    }

    public TreadControl(JPanel jPanel,ButtonEventService buttonEventService) {
        this.jPanel = jPanel;
        this.buttonEventService = buttonEventService;

    }
}