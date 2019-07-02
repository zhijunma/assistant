package com.cn.assistant.control;

import com.cn.assistant.service.ButtonEventService;
import com.cn.assistant.ui.HintUI;

/**
 * 虽然名字不详，但是这是一个线程类，里边的都是对组件停留时间的线程控制
 * @author fatah
 */
public class TreadControl {
    public ButtonEventService buttonEventService;
    public static boolean panelExit = false;
    //这个方法用来控制提示窗口的停留时间
    public  void HintUITread() {
        //方式1：相当于继承了Thread类，作为子类重写run()实现
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
//        //方式2:实现Runnable,Runnable作为匿名内部类
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("匿名内部类创建线程方式2...");
//            }
//        } ).start();
    }

    public TreadControl(ButtonEventService buttonEventService) {

        this.buttonEventService = buttonEventService;

    }
}