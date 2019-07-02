package com.cn.assistant.Utils;

import java.io.IOException;

public class FileOpenUtils {

    public static void openExeFile(String fileUrl) {

        final Runtime runtime = Runtime.getRuntime();
        Process process = null;

        try {
            process = runtime.exec(fileUrl);

        } catch (final Exception e) {
            System.out.println("Error exec!");
        }
    }
    //用记事本打开一个TXT文件
    public static void openTxtFile(String fileUrl) {
        try {
            Runtime.getRuntime().exec(("C:\\WINDOWS\\system32\\notepad.exe " + fileUrl));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //用记事本打开一个TXT文件
    public static void openWordFile(String fileUrl) {
        try {
            Runtime.getRuntime().exec(("F:\\Program Files\\WPS Office\\ksolaunch.exe " + fileUrl));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
