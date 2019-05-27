package com.cn.scnu.assistant.service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEventService implements ActionListener {

    Integer i = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (i == 0){
            System.out.println("0");
        }
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
