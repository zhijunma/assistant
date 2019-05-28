package com.cn.assistant.ui;

import com.cn.assistant.service.ButtonEventService;

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
        ButtonEventService.frameState = 1;
        //���ô���͸��
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));//alpha����Ϊ��

        jp.setLayout(null);
        jt.setBounds(80, 20, 600, 100);
        jt.setFont(new Font("����",Font.PLAIN,30));
        jp.add(jt);
        jp.setOpaque(false);

        //��������ȷ����ť�����Ժ���Ӱ�ť��JPanel��
        jb1 = new JButton("ȷ��");
        jb1.setBounds(520,120,60,30);
        //��������ȷ����ť����Ӧ
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                string = jt.getText();
                System.out.println(string);
            }
        });
        jp.add(jb1);
        //���������˳���ť�����Ժ���Ӱ�ť��JPanel��
        jb2 = new JButton("ȡ��");
        jb2.setBounds(600,120,60,30);
        //��������Ӧȡ����ť���¼�
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
    //������������رյ�ǰJFrame
    public void dispose1(){
        this.dispose();
        ButtonEventService.frameState = 0;
    }


}