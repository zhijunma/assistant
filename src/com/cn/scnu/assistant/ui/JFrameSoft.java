package com.cn.scnu.assistant.ui;

import javax.swing.*;
import java.awt.*;


@SuppressWarnings("serial")
public class JFrameSoft extends JFrame {

    public JFrameSoft(JPanelSoft panel) {


        this.setBounds(1000, 300, 500, 500);


        //设置窗体透明
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));//alpha分量为零

        //设置窗体永远在前
        this.setAlwaysOnTop(true);

        //设置默认Panel
        this.setContentPane(panel);
    }

}
