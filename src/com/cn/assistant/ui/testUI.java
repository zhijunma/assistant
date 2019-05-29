package com.cn.assistant.ui;

import com.cn.assistant.service.ButtonEventService;

import javax.swing.*;
import java.awt.*;

public class testUI extends JPanel {
    private JPanel jp = new JPanel();
    private JButton jb1;
    private JButton jb2;
    private JTextField jt = new JTextField();
    public String string;

    public testUI(JPanel panel) {
        panel.add(jp);
    }


    public void addCommandUI() {
        ButtonEventService.frameState = 1;
        //设置窗体透明
        this.setOpaque(false);

        jp.setLayout(null);
        jt.setBounds(80, 20, 600, 100);
        jt.setFont(new Font("宋体", Font.PLAIN, 30));
        jp.add(jt);
        jp.setOpaque(false);

        //这里设置确定按钮的属性和添加按钮到JPanel中
        jb1 = new JButton("确定");
        jb1.setBounds(520, 120, 60, 30);
        //这里设置确定按钮的响应
        jp.add(jb1);
        //这里设置退出按钮的属性和添加按钮到JPanel中
        jb2 = new JButton("取消");
        jb2.setBounds(600, 120, 60, 30);
        //这里是响应取消按钮的事件

        jp.add(jb2);

        this.add(jp);
        jt.setOpaque(false);

        this.setBounds(300, 500, 800, 200);
        this.setVisible(true);
    }
//
//
//        jt.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                if (e.getKeyChar() == KeyEvent.VK_ENTER){
//                    string = jt.getText();
//                    System.out.println(string);
//                    dispose1();
//                }
//            }
//        });
//    }
//
//    //这个方法用来关闭当前JFrame
//    public void dispose1() {
//        this.dispose();
//        ButtonEventService.frameState = 0;
//    }

}
