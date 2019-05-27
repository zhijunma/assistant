package com.cn.assistant.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertCommandUI extends JFrame {
    private JPanel jp=new JPanel();
    private JButton jb1;
    private JButton jb2;
    private JTextField jt=new JTextField();
    public String string;
    public InsertCommandUI(){

        //设置窗体透明
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));//alpha分量为零

        jp.setLayout(null);
        jt.setBounds(80, 20, 600, 100);
        jt.setFont(new Font("宋体",Font.PLAIN,30));
        jp.add(jt);
        jp.setOpaque(false);

        //这里设置确定按钮的属性和添加按钮到JPanel中
        jb1 = new JButton("确定");
        jb1.setBounds(520,120,60,30);
        //这里设置确定按钮的响应
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                string = jt.getText();
                System.out.println(string);
            }
        });
        jp.add(jb1);
        //这里设置退出按钮的属性和添加按钮到JPanel中
        jb2 = new JButton("取消");
        jb2.setBounds(600,120,60,30);
        //这里是响应取消按钮的事件
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose1();
            }
        });
        jp.add(jb2);

        this.add(jp);
        jt.setOpaque(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(300, 500, 800, 200);
        this.setVisible(true);


    }
    //这个方法用来关闭当前JFrame
    public void dispose1(){
        this.dispose();
    }


}