package com.cn.assistant.service;

import javax.swing.filechooser.FileSystemView;
import java.io.IOException;

public class FileTypeOpenWay {
    //�ü��±���һ��TXT�ļ�
    public void openTxt(String fileName){
        try {
            Runtime.getRuntime().exec(("C:\\WINDOWS\\system32\\notepad.exe " + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //�ü��±���һ��TXT�ļ�
    public void openDesktopTxt(String fileName){
        try {
            Runtime.getRuntime().exec(("C:\\WINDOWS\\system32\\notepad.exe "+ FileSystemView.getFileSystemView().getHomeDirectory()+"/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new FileTypeOpenWay().openTxt("�½��ı��ĵ�.txt");
    }
}
