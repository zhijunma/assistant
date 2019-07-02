package com.cn.assistant.ui;

import com.cn.assistant.Utils.FileOpenUtils;
import com.cn.assistant.service.ButtonEventService;
import com.cn.assistant.service.GetAppURLService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

/**
 * 这个类用来处理当搜索到多个符合条件的文件时的动作
 * 将所有的搜索到的文件做成按钮
 */
public class ChooseUI extends JPanel {
    public JButton jButton[];
    public JPanel superJP;
    public static String str;
    public List list;

    public ChooseUI(List list,JPanel jPanel) {
        this.superJP = jPanel;
        this.list = list;
        addPanel();
        this.setBounds(250, 50, 250, list.size() * 50);
        this.setVisible(true);
        this.setOpaque(false);
    }

    /**
     * 绘制panel背景  但是因为按钮在上  所以没能很好的处理
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) { //关键代码：重写绘制组件外观
        super.paintComponent(g);
        ImageIcon image = new ImageIcon("image/background/1.png"); // 获取图片路径
        g.drawImage(image.getImage(), -20, -20, this.getWidth(), this.getHeight() * list.size(), this);
    }

    public void addPanel() {
        Object[] array = list.toArray(new String[0]);
        JButton[] jButton = new JButton[list.size()];
        for (int i = 0; i < list.size(); i++) {

            jButton[i] = new JButton();

            jButton[i].setHorizontalTextPosition(SwingConstants.CENTER);

            jButton[i].setOpaque(false);//设置控件是否透明，true为不透明，false为透明
            jButton[i].setFocusPainted(false);//设置这个按钮是不是获得焦点
            jButton[i].setBorderPainted(false);//设置是否绘制边框
            jButton[i].setBorder(null);//设置边框

            String s = array[i].toString();
            jButton[i].setText(s);
            jButton[i].setForeground(Color.red);
            jButton[i].setBounds(0, 50 * i, 250, 50);
            setIcon("image/buttonImage/tig.png", jButton[i]);
            jButton[i].addActionListener(new Event(jButton[i],superJP,this));
            this.add(jButton[i]);
        }
    }

    /**
     * 这个方法用来给按钮设置背景
     * @param file
     * @param iconButton
     */
    public void setIcon(String file, JButton iconButton) {
        ImageIcon icon = new ImageIcon(file);
        Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),
                iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
        icon = new ImageIcon(temp);
        iconButton.setIcon(icon);
    }

}

/**
 * 这是一个事件处理类  里面写明了对按钮的响应和处理
 */
class Event implements ActionListener {
    //文件路径  绝对路径
    public String fileUrl;
    //文件类型 获取文件的后缀
    public String fileType;
    //文件类型 桌面文件的后缀
    public String deskFileType;
    //文件名
    public static String fileName;
    public JButton jButton;
    public JPanel superJPanel;
    public JPanel jPanel;

    /**
     * 这个构造方法中所需的三个参数分别是
     * 1.需要进行事件定义的按钮
     * 2.总窗口  方便移除
     * 3.按钮添加的窗口
     * @param jButton
     * @param jPanel
     * @param jPanel1
     */
    public Event(JButton jButton,JPanel jPanel,JPanel jPanel1) {
        this.jButton = jButton;
        this.superJPanel = jPanel;
        this.jPanel = jPanel1;
    }

    /**
     * 按钮事件的定义
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //判断桌面文件的类型 并根据相应的类型决定打开方式
        fileName = jButton.getText();
        deskFileType = GetFileType(fileName);
//                            System.out.println(deskFileType);
        if (deskFileType.equals("lnk") || deskFileType.equals("LNK")) {
            try {
                //通过桌面的快捷方式获取快捷方式的应用的决对地址
                fileUrl = new GetAppURLService(new File(GetAppURLService.deskUrl +
                        fileName.toString().replaceAll("\\[", "").replaceAll("]", "")))
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
                // 判断文件是不是可打开的TXT文档  并打开这个文档
                else if (fileType.equals("txt") || fileType.equals("TXT")) {
                    FileOpenUtils.openTxtFile(fileUrl);
                }
                //Todo 使用case来判断文件的类型和打开的方式
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (deskFileType.equals("exe") || deskFileType.equals("EXE")) {
            fileUrl = GetAppURLService.deskUrl +
                    fileName.toString().replaceAll("\\[", "").replaceAll("]", "");
            FileOpenUtils.openExeFile(fileUrl);
        } else if (deskFileType.equals("txt") || deskFileType.equals("TXT")) {
            fileUrl = GetAppURLService.deskUrl +
                    fileName.toString().replaceAll("\\[", "").replaceAll("]", "");
            FileOpenUtils.openTxtFile(fileUrl);
        } else if (fileType.equals("doc") || fileType.equals("ocx")
                || fileType.equals("pdf") || fileType.equals("xls")) {
            fileUrl = GetAppURLService.deskUrl +
                    fileName.toString().replaceAll("\\[", "").replaceAll("]", "");
            FileOpenUtils.openWordFile(fileUrl);
        }
        superJPanel.remove(jPanel);
        ButtonEventService.chooseButtonExit = false;
        System.out.println(ButtonEventService.chooseButtonExit);
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