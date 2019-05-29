package com.cn.assistant.ui;

import javax.swing.*;
import java.awt.*;


@SuppressWarnings("serial")
public class JFrameSoft extends JFrame {

    public JFrameSoft(JPanelSoft panel) {
        this.setLayout(null);
        this.setBounds(300, 450, 1200, 500);
        //设置窗体透明
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));//alpha分量为零

        //设置窗体永远在前
        this.setAlwaysOnTop(true);
        panel.setBounds(0,0,1100,500);
        //设置默认Panel
        this.add(panel);
        //测试
        JTextField jt = new JTextField();
        jt.setBounds(80, 20, 600, 100);
        jt.setFont(new Font("宋体", Font.PLAIN, 30));
//        this.add(jt);
    }

}
