package com.cn.assistant.service;

import com.cn.assistant.Utils.FileOpenUtils;
import com.cn.assistant.control.SoftControl;
import com.cn.assistant.control.TreadControl;
import com.cn.assistant.entity.Dialog;
import com.cn.assistant.ui.ChooseUI;
import com.cn.assistant.ui.HintUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public class ButtonEventService implements ActionListener {

    public Dialog dialog;
    public SoftControl softControl;
    /**
     * 主窗口按钮标记
     */
    Integer i = 0;
    /**
     * 公用的文本框
     */
    public JTextField jt;
    /**
     * 文本框所在的panel
     */
    public JPanel jPanel;
    /**
     * 文件路径  绝对路径
     */
    public String fileUrl;
    /**
     *文件类型 获取文件的后缀
     */
    public String fileType;
    //文件类型 桌面文件的后缀
    public String deskFileType;
    //文件名
    public static String fileName;
    //组件是否存在，默认不存在
    public static boolean panelExit = false;
    /**
     * 提示窗口
     */
    public static HintUI test;
    /**
     * 选择窗口
     */
    public static ChooseUI chooseUI;
    /**
     * 向提示窗口传送按钮值
     */
    public static int buttonNumber = 0;
    /**
     * 标记选择按钮的是否存在  0：不存在；1：存在
     */
    public static boolean chooseButtonExit = false;

    /**
     * 这个事件用来响应文本框的动作
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //响应输入文本的按钮
        if (chooseButtonExit == true){
            jPanel.remove(chooseUI);
            chooseButtonExit = false;
        }
        if (i == 0) {
            if (panelExit == false) {
                buttonNumber = 0;
                new TreadControl(this).HintUITread();
                setCommadFrame();
                //添加组件
                jPanel.add(jt);
                panelExit = true;
            } else {
                jPanel.remove(jt);
                panelExit = false;
            }

        } else if (i == 1) {

            if (TreadControl.panelExit == false) {
                buttonNumber = 1;
                new TreadControl(this).HintUITread();
            } else {
                jPanel.remove(test);
                panelExit = false;

            }
        } else if (i == 2) {
            if (panelExit == false) {
                buttonNumber = 2;
                new TreadControl(this).HintUITread();
            } else {
                jPanel.remove(test);
                panelExit = false;
            }
            System.out.println("2");
        } else if (i == 3) {
            System.out.println("3");
            SoftControl.frame.setVisible(false);
        } else if (i == 4) {
            System.out.println("4");
            System.exit(0);
        }

    }


    //构造方法，获取按钮标识和当前panel
    public ButtonEventService(int i, JPanel jPanel, SoftControl softControl) {
        this.i = i;
        this.jPanel = jPanel;
        this.softControl = softControl;
    }

    /**
     * 给文本框参数进行配置
     */
    public void setCommadFrame() {
        jt = new JTextField();
        jt.setBounds(80, 120, 650, 100);
        jt.setFont(new Font("宋体", Font.PLAIN, 30));
        //给文本框添加enter键的监听
        jt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    if (chooseButtonExit == true){
                        jPanel.remove(chooseUI);
                        chooseButtonExit = false;
                    }
                    if (!jt.getText().isEmpty()) {
                        HashMap<String, Object> map = new HashMap<>();
                        map = new SelectAppLnkService(jt.getText()).filesName;
                        //
                        if (map.containsKey("fileNameList")) {
                            Object fileNameList = map.get("fileNameList");
                            List fileNameList1 = (List) fileNameList;
                            if (fileNameList1.size() > 1 && chooseButtonExit == false) {
                                jPanel.add(chooseUI = new ChooseUI(fileNameList1,jPanel));
                                chooseButtonExit = true;
                                //todo 在这里应该考虑到：当按钮查找出来后，不进行操作，直接退出的情况的处理方式
                            } else if (fileNameList1.size() == 1){
                            fileName = fileNameList.toString().replaceAll("\\[", "").replaceAll("]", "");
                            if (!fileName.isEmpty()) {
                                //判断桌面文件的类型 并根据相应的类型决定打开方式
                                deskFileType = GetFileType(fileName);
//                            System.out.println(deskFileType);
                                if (deskFileType.equals("lnk") || deskFileType.equals("LNK")) {
                                    try {
                                        //通过桌面的快捷方式获取快捷方式的应用的决对地址
                                        fileUrl = new GetAppURLService(new File(GetAppURLService.deskUrl +
                                                fileNameList.toString().replaceAll("\\[", "").replaceAll("]", "")))
                                                .getRealFilename();
                                        fileType = GetFileType(fileUrl);
                                        //注意这里无法使用“==”进行判断
                                        //判断桌面快捷方式指向的类型
                                        // 文件时可打开的EXE文件  并打开这个文件
                                        if (fileType.equals("exe") || fileType.equals("EXE")) {
                                            //使用打开文件的工具类
                                            FileOpenUtils.openExeFile(fileUrl);
                                        } else if (fileType.equals("doc") || fileType.equals("ocx")
                                                || fileType.equals("pdf") || fileType.equals("xls")) {
                                            System.out.println(fileUrl);
                                            FileOpenUtils.openWordFile(fileUrl);
                                        }
//                                    判断文件是不是可打开的TXT文档  并打开这个文档
                                        else if (fileType.equals("txt") || fileType.equals("TXT")) {
                                            FileOpenUtils.openTxtFile(fileUrl);
                                        }
                                        //Todo 使用case来判断文件的类型和打开的方式
                                    } catch (Exception e1) {
                                        e1.printStackTrace();
                                    }
                                } else if (deskFileType.equals("exe") || deskFileType.equals("EXE")) {
                                    fileUrl = GetAppURLService.deskUrl +
                                            fileNameList.toString().replaceAll("\\[", "").replaceAll("]", "");
                                    FileOpenUtils.openExeFile(fileUrl);
                                } else if (deskFileType.equals("txt") || deskFileType.equals("TXT")) {
                                    fileUrl = GetAppURLService.deskUrl +
                                            fileNameList.toString().replaceAll("\\[", "").replaceAll("]", "");
                                    FileOpenUtils.openTxtFile(fileUrl);
                                } else if (fileType.equals("doc") || fileType.equals("ocx")
                                        || fileType.equals("pdf") || fileType.equals("xls")) {
                                    fileUrl = GetAppURLService.deskUrl +
                                            fileNameList.toString().replaceAll("\\[", "").replaceAll("]", "");
                                    FileOpenUtils.openWordFile(fileUrl);
                                }

                            } else {
                                //如果输入的命令未找到将要执行的动作
                                System.out.println("fuckkkk");
//                                jPanelSoft.paintComponent(Graphics g);
                            }
                            }
                            jPanel.remove(jt);
                        }
                    } else {
                        jPanel.remove(jt);
                    }
                } else if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
                    jPanel.remove(jt);
                }
            }
        });
    }

    /**
     * 获取文件的后缀名
     */
    public String GetFileType(String string) {
        int length = string.length();
        //截取最后3位后缀名
        String str = string.substring(length - 3, length);
        return str;
    }

}
