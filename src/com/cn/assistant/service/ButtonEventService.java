package com.cn.assistant.service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ButtonEventService implements ActionListener {
    Integer i = 0;
    //取消按钮
    private JButton exitJB;
    //确定按钮
    private JButton ensureJB;
    public JTextField jt;
    public JPanel jPanel;
    public static int frameState = 0;
    public String string;

    @Override
    public void actionPerformed(ActionEvent e) {
        //响应输入文本的按钮
        if (i == 0){
//            TreadControl treadControl = new TreadControl();
//            treadControl.InsertCommandUITread();
            //执行参数配置
            setCommadFrame();
            //添加组件
            jPanel.add(jt);
//            jPanel.add(ensureJB);
//            setButtonEvent(ensureJB);
//            jPanel.add(exitJB);
//            setButtonEvent(exitJB);
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
    public ButtonEventService(int i,JPanel jPanel){
        this.i = i;
        this.jPanel = jPanel;
    }

    public void setCommadFrame() {
//        //给确定按钮进行参数设置
//        ensureJB = new JButton("确定");
//        ensureJB.setBounds(670,220,60,40);
//        ensureJB.setBorderPainted(false);
//        //给取消按钮进行参数设置
//        exitJB = new JButton("取消");
//        exitJB.setBounds(590,220,60,40);
//        exitJB.setBorderPainted(false);
//        //给文本框进行参数设置
        jt = new JTextField();
        jt.setBounds(80, 120, 650, 100);
        jt.setFont(new Font("宋体", Font.PLAIN, 30));
        //设置文本框透明
//            jt.setOpaque(false);
        jt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER){
                    string = jt.getText();
                    System.out.println(string);
                    jPanel.remove(jt);
//                    jPanel.remove(ensureJB);
//                    jPanel.remove(exitJB);
                }
            }
        });
    }

    /**
     * 设置按钮事件
     * @param jButton
     */
//    public void setButtonEvent(JButton jButton){
//        if (jButton.getText() == "确定"){
//            jButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    if (jt.getText().isEmpty()){
//                        jt.setText("不说点什么吗？");
//                    }
//                    else {
//                        jPanel.remove(jButton);
//                        jPanel.remove(jt);
//                        jPanel.remove(exitJB);
//                    }
//                    }
//                });
//
//        }
//        else if (jButton.getText() == "取消"){
//            jButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
////                    System.out.println("退出");
//                    jPanel.remove(jButton);
//                    jPanel.remove(jt);
//                    jPanel.remove(ensureJB);
//                }
//            });
//        }
//
//    }

}
