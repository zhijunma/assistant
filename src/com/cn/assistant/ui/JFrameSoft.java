package com.cn.assistant.ui;

import javax.swing.*;
import java.awt.*;


@SuppressWarnings("serial")
public class JFrameSoft extends JFrame {

    public JFrameSoft(JPanelSoft panel) {
        this.setLayout(null);
        this.setBounds(300, 450, 1200, 500);
        //���ô���͸��
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));//alpha����Ϊ��

        //���ô�����Զ��ǰ
        this.setAlwaysOnTop(true);
        panel.setBounds(0,0,1100,500);
        //����Ĭ��Panel
        this.add(panel);
        //����
        JTextField jt = new JTextField();
        jt.setBounds(80, 20, 600, 100);
        jt.setFont(new Font("����", Font.PLAIN, 30));
//        this.add(jt);
    }

}
