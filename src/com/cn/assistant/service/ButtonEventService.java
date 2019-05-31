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
    //文件路径  绝对路径
    public String fileUrl;
    //文件类型 获取文件的后缀
    public String fileType;
    //文件名
    public String fileName;
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
                        fileUrl = jt.getText();
                        HashMap<String, Object> map = new HashMap<>();
                        map = new SelectAppLnkService(jt.getText()).filesName;
//                        System.out.println(GetFileType(map.get("fileNameList").toString().replaceAll("\\[", "").replaceAll("]", "")));
                        fileName = map.get("fileNameList").toString().replaceAll("\\[", "").replaceAll("]", "");
                        //判断文件的类型 并根据相应的类型决定打开方式
                        if (GetFileType(fileName).equals("lnk") || GetFileType(fileName).equals("LNK")) {
                            try {
                                //通过桌面的快捷方式获取快捷方式的应用的决对地址
                                fileUrl = new GetAppURLService(new File(GetAppURLService.deskUrl +
                                        map.get("fileNameList").toString().replaceAll("\\[", "").replaceAll("]", "")))
                                        .getRealFilename();
                                fileType = GetFileType(fileUrl);
                                System.out.println(fileType);
//                                if (!fileUrl.isEmpty()) {
                                    //注意这里无法使用“==”进行判断
                                    //判断文件时可打开的EXE文件  并打开这个文件
                                    if (fileType.equals("exe") || fileType.equals("EXE")) {
                                        GetAppURLService.openExe(fileUrl);
                                    }
                                    else if (fileType.equals("doc") || fileType.equals("docx")) {
//                                        todo 打开doc文档的方式
                                    }
//                                    判断文件是不是可打开的TXT文档  并打开这个文档
                                    else if (fileType.equals("txt") || fileType.equals("TXT")) {
                                        new FileTypeOpenWay().openTxt(fileUrl);
                                    }
                                    //Todo 使用case来判断文件的类型和打开的方式
//                                }
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }
                        System.out.println(fileUrl);
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
