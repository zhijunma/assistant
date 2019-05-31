package com.cn.assistant.service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;

public class ButtonEventService implements ActionListener {
    //主窗口按钮标记
    Integer i = 0;
    //公用的文本框
    public JTextField jt;
    //文本框所在的panel
    public JPanel jPanel;
    //通用字符串
    public String string;
    //文件类型 获取文件的后缀
    public String fileType;
    public static int frameState = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        //响应输入文本的按钮
        if (i == 0){
            setCommadFrame();
            //添加组件
            jt.requestFocus();
            jPanel.add(jt);
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
    //构造方法，获取按钮标识和当前panel
    public ButtonEventService(int i,JPanel jPanel){
        this.i = i;
        this.jPanel = jPanel;
    }

    /**
     * 给文本框参数进行配置
     */
    public void setCommadFrame() {
//        //给确定按钮进行参数设置
//        ensureJB = new JButton("确定");
//        ensureJB.setBounds(670,220,60,40);
//        ensureJB.setBorderPainted(false);
//        //给取消按钮进行参数设置
//        exitJB = new JButton("取消");
//        exitJB.setBounds(590,220,60,40);
//        exitJB.setBorderPainted(false);
//        //给文本框进行参数设置
        jt = new JTextField();
        jt.setBounds(80, 120, 650, 100);
        jt.setFont(new Font("宋体", Font.PLAIN, 30));
        //设置文本框透明
//        jt.setOpaque(false);
//        jt.requestFocus();
//        jt.addComponentListener(new ComponentAdapter() {
//            @Override
//            public void componentShown(ComponentEvent e) {
//                jt.requestFocus();
//            };
//        });
        jt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER){
                    if (!jt.getText().isEmpty()){
                        string = jt.getText();
                        HashMap<String, Object> map = new HashMap<>();
                        map = new SelectAppLnkService(jt.getText()).filesName;
                        try {
                            string = new GetAppURLService(new File(GetAppURLService.deskUrl +
                                    map.get("fileNameList").toString().replaceAll("\\[","").replaceAll("]","")))
                            .getRealFilename();
                            fileType = GetFileType(string);
                            System.out.println(fileType);
                            System.out.println("+++++++++"+string);
                            if (!string.isEmpty()){
                                    GetAppURLService.openExe(string);
                                    //Todo 使用case来判断文件的类型和打开的方式
                            }
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        System.out.println(string);
                        jPanel.remove(jt);
                    }
                    else {
                        jPanel.remove(jt);
                    }
//                    jPanel.remove(ensureJB);
//                    jPanel.remove(exitJB);
                }
            }
        });
    }
    /**
     * 获取文件的后缀名
     */
    public String GetFileType(String string){
        int length = string.length();
        //截取最后3位后缀名
        String str = string.substring(length-3, length);
        return str;
    }
    /**
     * 设置按钮事件
     * @param jButton
     */
//    public void setButtonEvent(JButton jButton){
//        if (jButton.getText() == "确定"){
//            jButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    if (jt.getText().isEmpty()){
//                        jt.setText("不说点什么吗？");
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
//        else if (jButton.getText() == "取消"){
//            jButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
////                    System.out.println("退出");
//                    jPanel.remove(jButton);
//                    jPanel.remove(jt);
//                    jPanel.remove(ensureJB);
//                }
//            });
//        }
//
//    }

}
