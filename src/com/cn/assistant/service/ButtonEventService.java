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
    //�����ڰ�ť���
    Integer i = 0;
    //���õ��ı���
    public JTextField jt;
    //�ı������ڵ�panel
    public JPanel jPanel;
    //�ļ�·��  ����·��
    public String fileUrl;
    //�ļ����� ��ȡ�ļ��ĺ�׺
    public String fileType;
    //�ļ���
    public String fileName;
    public static int frameState = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        //��Ӧ�����ı��İ�ť
        if (i == 0){
            setCommadFrame();
            //������
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
    //���췽������ȡ��ť��ʶ�͵�ǰpanel
    public ButtonEventService(int i,JPanel jPanel){
        this.i = i;
        this.jPanel = jPanel;
    }

    /**
     * ���ı��������������
     */
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
                        //�ж��ļ������� ��������Ӧ�����;����򿪷�ʽ
                        if (GetFileType(fileName).equals("lnk") || GetFileType(fileName).equals("LNK")) {
                            try {
                                //ͨ������Ŀ�ݷ�ʽ��ȡ��ݷ�ʽ��Ӧ�õľ��Ե�ַ
                                fileUrl = new GetAppURLService(new File(GetAppURLService.deskUrl +
                                        map.get("fileNameList").toString().replaceAll("\\[", "").replaceAll("]", "")))
                                        .getRealFilename();
                                fileType = GetFileType(fileUrl);
                                System.out.println(fileType);
//                                if (!fileUrl.isEmpty()) {
                                    //ע�������޷�ʹ�á�==�������ж�
                                    //�ж��ļ�ʱ�ɴ򿪵�EXE�ļ�  ��������ļ�
                                    if (fileType.equals("exe") || fileType.equals("EXE")) {
                                        GetAppURLService.openExe(fileUrl);
                                    }
                                    else if (fileType.equals("doc") || fileType.equals("docx")) {
//                                        todo ��doc�ĵ��ķ�ʽ
                                    }
//                                    �ж��ļ��ǲ��ǿɴ򿪵�TXT�ĵ�  ��������ĵ�
                                    else if (fileType.equals("txt") || fileType.equals("TXT")) {
                                        new FileTypeOpenWay().openTxt(fileUrl);
                                    }
                                    //Todo ʹ��case���ж��ļ������ͺʹ򿪵ķ�ʽ
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
     * ��ȡ�ļ��ĺ�׺��
     */
    public String GetFileType(String string){
        int length = string.length();
        //��ȡ���3λ��׺��
        String str = string.substring(length-3, length);
        return str;
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
