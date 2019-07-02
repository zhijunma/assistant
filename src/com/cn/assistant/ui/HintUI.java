package com.cn.assistant.ui;

import com.cn.assistant.entity.Say;
import com.cn.assistant.entity.SoftIcons;

import javax.swing.*;
import java.awt.*;

/**
 * 这个组件用来显示提示消息
 */
public class HintUI extends JPanel{

    int i;



    public static void main(String[] args) {
        new HintUI(1);
    }

    //构造函数
    public HintUI(int i) {
        this.add(new Panel());
        this.setBounds(700, 0, 240, 80);
        this.setOpaque(false);
        this.i= i;
    }

    /**
     * 这个方法虽然没有写在构造方法中，但是只能在构造方法中使用，
     * 即使你不在构造方法中写到，它也会在构建这个类时自动调用
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //在窗口绘制图片，位置的当前组件的相对位置
        g.drawImage(SoftIcons.DIALOG_IMG ,0 , 0, null);
        //设置这支画笔的颜色
        g.setColor(Color.green);
        //设置这支画笔的字体和大小
        g.setFont(new Font("宋体",Font.PLAIN,15));
        //设置这支画笔要写的内容
        g.drawString(Say.buttonWord[i],10,40);
    }

    }