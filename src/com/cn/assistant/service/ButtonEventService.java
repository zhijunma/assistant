package com.cn.assistant.service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ButtonEventService implements ActionListener {
    Integer i = 0;
    //ȡ����ť
    private JButton exitJB;
    //ȷ����ť
    private JButton ensureJB;
    public JTextField jt;
    public JPanel jPanel;
    public static int frameState = 0;
    public String string;

    @Override
    public void actionPerformed(ActionEvent e) {
        //��Ӧ�����ı��İ�ť
        if (i == 0){
//            TreadControl treadControl = new TreadControl();
//            treadControl.InsertCommandUITread();
            //ִ�в�������
            setCommadFrame();
            //������
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
//        //��ȷ����ť���в�������
//        ensureJB = new JButton("ȷ��");
//        ensureJB.setBounds(670,220,60,40);
//        ensureJB.setBorderPainted(false);
//        //��ȡ����ť���в�������
//        exitJB = new JButton("ȡ��");
//        exitJB.setBounds(590,220,60,40);
//        exitJB.setBorderPainted(false);
//        //���ı�����в�������
        jt = new JTextField();
        jt.setBounds(80, 120, 650, 100);
        jt.setFont(new Font("����", Font.PLAIN, 30));
        //�����ı���͸��
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
     * ���ð�ť�¼�
     * @param jButton
     */
//    public void setButtonEvent(JButton jButton){
//        if (jButton.getText() == "ȷ��"){
//            jButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    if (jt.getText().isEmpty()){
//                        jt.setText("��˵��ʲô��");
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
//        else if (jButton.getText() == "ȡ��"){
//            jButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
////                    System.out.println("�˳�");
//                    jPanel.remove(jButton);
//                    jPanel.remove(jt);
//                    jPanel.remove(ensureJB);
//                }
//            });
//        }
//
//    }

}
