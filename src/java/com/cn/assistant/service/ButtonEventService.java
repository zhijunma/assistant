package java.com.cn.assistant.service;

import java.com.cn.assistant.ui.InsertCommandUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEventService implements ActionListener {
    public Behavior behavior;
    Integer i = 0;
    JFrame jFrame = new JFrame();
    @Override
    public void actionPerformed(ActionEvent e) {
        //响应输入文本的按钮
        if (i == 0){
            new InsertCommandUI();
            }
        //
        else if (i == 1){
            System.out.println("1");
        }
        else if (i == 2){
            System.out.println("2");
        }
        else if (i == 3){
            System.out.println("3");
        }
        else if (i == 4){
            System.out.println("4");
        }

    }
    public ButtonEventService(int i){
        this.i = i;
    }
}
