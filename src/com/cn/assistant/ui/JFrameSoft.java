package com.cn.assistant.ui;

import javax.swing.*;
import java.awt.*;


@SuppressWarnings("serial")
public class JFrameSoft extends JFrame {

    public JFrameSoft(JPanelSoft panel) {


        this.setBounds(1000, 450, 500, 500);
        //���ô���͸��
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));//alpha����Ϊ��

        //���ô�����Զ��ǰ
        this.setAlwaysOnTop(true);

        //����Ĭ��Panel
        this.setContentPane(panel);
    }

}
