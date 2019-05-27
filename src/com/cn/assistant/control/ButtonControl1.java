package com.cn.assistant.control;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonControl1 implements ActionListener {
    private static JFrame frame;

    @Override
    public void actionPerformed(ActionEvent e) {  //定义处理事件的方法
        // TODO Auto-generated method stub
        String name = e.getActionCommand();//返回与此动作相关的命令字符串
        ImageIcon imageIcon = new ImageIcon();
            JOptionPane.showMessageDialog(frame, "登录失败", "提示", JOptionPane.ERROR_MESSAGE);

    }
}