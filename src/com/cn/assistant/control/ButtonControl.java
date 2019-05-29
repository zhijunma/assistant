//package com.cn.assistant.control;
//
//import com.cn.assistant.service.ButtonEventService;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class ButtonControl {
//    int i = 0;
//    ImageIcon [] img = new ImageIcon[5];
//    //创建一组按钮
//    JButton [] jButtons = new JButton[5];
//
//    public ButtonControl(JPanel panel){
//        AddPanel();
//        panel.add(jButtons[0]);
//        panel.add(jButtons[1]);
//        panel.add(jButtons[2]);
//        panel.add(jButtons[3]);
//        panel.add(jButtons[4]);
//    }
//
//
//    public JButton[] AddPanel(){
//
//        for (int i = 0; i<5 ;i++){
//            img[i] = new ImageIcon("image/buttonImage/"+i+".png");
//            Image temp = img[i].getImage().getScaledInstance(20,20, img[i].getImage().SCALE_DEFAULT);
//            img[i] = new ImageIcon(temp);
//        }
//        //创建一个带图片样式的按钮
//        jButtons[0] = new JButton(img[0]);
//        //设置按钮位置，大小
//        jButtons[0].setBounds(250,240,20,20);
//        //隐藏按钮边框
//        jButtons[0].setBorderPainted(false);
//        jButtons[0].addActionListener(new ButtonEventService(0));
//        jButtons[1] = new JButton(img[1]);
//        jButtons[1].setBounds(250,210,20,20);
//        jButtons[1].setBorderPainted(false);
//        jButtons[1].addActionListener(new ButtonEventService(1));
//        jButtons[2] = new JButton(img[2]);
//        jButtons[2].setBounds(250,180,20,20);
//        jButtons[2].setBorderPainted(false);
//        jButtons[2].addActionListener(new ButtonEventService(2));
//        jButtons[3] = new JButton(img[3]);
//        jButtons[3].setBounds(250,150,20,20);
//        jButtons[3].setBorderPainted(false);
//        jButtons[3].addActionListener(new ButtonEventService(3));
//        jButtons[4] = new JButton(img[4]);
//        jButtons[4].setBounds(250,120,20,20);
//        jButtons[4].setBorderPainted(false);
//        jButtons[4].addActionListener(new ButtonEventService(4));
//        return jButtons;
//    }
//}
