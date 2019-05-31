package com.cn.assistant.service;

import javax.swing.filechooser.FileSystemView;
import java.io.IOException;

public class FileTypeOpenWay {
    //用记事本打开一个TXT文件
    public void openTxt(String fileName){
        try {
            Runtime.getRuntime().exec(("C:\\WINDOWS\\system32\\notepad.exe " + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //用记事本打开一个TXT文件
    public void openDesktopTxt(String fileName){
        try {
            Runtime.getRuntime().exec(("C:\\WINDOWS\\system32\\notepad.exe "+ FileSystemView.getFileSystemView().getHomeDirectory()+"/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new FileTypeOpenWay().openTxt("新建文本文档.txt");
    }
}
