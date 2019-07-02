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
     * �����ڰ�ť���
     */
    Integer i = 0;
    /**
     * ���õ��ı���
     */
    public JTextField jt;
    /**
     * �ı������ڵ�panel
     */
    public JPanel jPanel;
    /**
     * �ļ�·��  ����·��
     */
    public String fileUrl;
    /**
     *�ļ����� ��ȡ�ļ��ĺ�׺
     */
    public String fileType;
    //�ļ����� �����ļ��ĺ�׺
    public String deskFileType;
    //�ļ���
    public static String fileName;
    //����Ƿ���ڣ�Ĭ�ϲ�����
    public static boolean panelExit = false;
    /**
     * ��ʾ����
     */
    public static HintUI test;
    /**
     * ѡ�񴰿�
     */
    public static ChooseUI chooseUI;
    /**
     * ����ʾ���ڴ��Ͱ�ťֵ
     */
    public static int buttonNumber = 0;
    /**
     * ���ѡ��ť���Ƿ����  0�������ڣ�1������
     */
    public static boolean chooseButtonExit = false;

    /**
     * ����¼�������Ӧ�ı���Ķ���
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //��Ӧ�����ı��İ�ť
        if (chooseButtonExit == true){
            jPanel.remove(chooseUI);
            chooseButtonExit = false;
        }
        if (i == 0) {
            if (panelExit == false) {
                buttonNumber = 0;
                new TreadControl(this).HintUITread();
                setCommadFrame();
                //������
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


    //���췽������ȡ��ť��ʶ�͵�ǰpanel
    public ButtonEventService(int i, JPanel jPanel, SoftControl softControl) {
        this.i = i;
        this.jPanel = jPanel;
        this.softControl = softControl;
    }

    /**
     * ���ı��������������
     */
    public void setCommadFrame() {
        jt = new JTextField();
        jt.setBounds(80, 120, 650, 100);
        jt.setFont(new Font("����", Font.PLAIN, 30));
        //���ı������enter���ļ���
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
                                //todo ������Ӧ�ÿ��ǵ�������ť���ҳ����󣬲����в�����ֱ���˳�������Ĵ���ʽ
                            } else if (fileNameList1.size() == 1){
                            fileName = fileNameList.toString().replaceAll("\\[", "").replaceAll("]", "");
                            if (!fileName.isEmpty()) {
                                //�ж������ļ������� ��������Ӧ�����;����򿪷�ʽ
                                deskFileType = GetFileType(fileName);
//                            System.out.println(deskFileType);
                                if (deskFileType.equals("lnk") || deskFileType.equals("LNK")) {
                                    try {
                                        //ͨ������Ŀ�ݷ�ʽ��ȡ��ݷ�ʽ��Ӧ�õľ��Ե�ַ
                                        fileUrl = new GetAppURLService(new File(GetAppURLService.deskUrl +
                                                fileNameList.toString().replaceAll("\\[", "").replaceAll("]", "")))
                                                .getRealFilename();
                                        fileType = GetFileType(fileUrl);
                                        //ע�������޷�ʹ�á�==�������ж�
                                        //�ж������ݷ�ʽָ�������
                                        // �ļ�ʱ�ɴ򿪵�EXE�ļ�  ��������ļ�
                                        if (fileType.equals("exe") || fileType.equals("EXE")) {
                                            //ʹ�ô��ļ��Ĺ�����
                                            FileOpenUtils.openExeFile(fileUrl);
                                        } else if (fileType.equals("doc") || fileType.equals("ocx")
                                                || fileType.equals("pdf") || fileType.equals("xls")) {
                                            System.out.println(fileUrl);
                                            FileOpenUtils.openWordFile(fileUrl);
                                        }
//                                    �ж��ļ��ǲ��ǿɴ򿪵�TXT�ĵ�  ��������ĵ�
                                        else if (fileType.equals("txt") || fileType.equals("TXT")) {
                                            FileOpenUtils.openTxtFile(fileUrl);
                                        }
                                        //Todo ʹ��case���ж��ļ������ͺʹ򿪵ķ�ʽ
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
                                //������������δ�ҵ���Ҫִ�еĶ���
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
     * ��ȡ�ļ��ĺ�׺��
     */
    public String GetFileType(String string) {
        int length = string.length();
        //��ȡ���3λ��׺��
        String str = string.substring(length - 3, length);
        return str;
    }

}
