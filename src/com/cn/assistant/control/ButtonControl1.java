package com.cn.assistant.control;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonControl1 implements ActionListener {
    private static JFrame frame;

    @Override
    public void actionPerformed(ActionEvent e) {  //���崦���¼��ķ���
        // TODO Auto-generated method stub
        String name = e.getActionCommand();//������˶�����ص������ַ���
        ImageIcon imageIcon = new ImageIcon();
            JOptionPane.showMessageDialog(frame, "��¼ʧ��", "��ʾ", JOptionPane.ERROR_MESSAGE);

    }
}