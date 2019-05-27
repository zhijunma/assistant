package com.cn.assistant.service;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SelectAppLnkService {
    String desktopURL;
    HashMap<String,Object> filesName;
    public SelectAppLnkService(String queStr){
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File desktop=fsv.getHomeDirectory();    //����Ƕ�ȡ����·���ķ�����
        desktopURL = desktop.getPath();
        filesName = getFilesName(desktopURL, queStr);
        System.out.print(filesName);
    }
    /**
     * ��ȡ�ļ����������ļ������� + ģ����ѯ��������Ҫģ����ѯʱ��queryStr���ջ�null���ɣ�
     * 1.��·��������ʱ��map����retTypeֵΪ1
     * 2.��·��Ϊ�ļ�·��ʱ��map����retTypeֵΪ2���ļ���fileNameֵΪ�ļ���
     * 3.��·�������ļ���ʱ��map����retTypeֵΪ3���ļ����б�fileNameList���ļ������б�folderNameList
     * @param folderPath ·��
     * @param queryStr ģ����ѯ�ַ���
     * @return
     */
    public static HashMap<String, Object> getFilesName(String folderPath , String queryStr) {
        HashMap<String, Object> map = new HashMap<>();
        List<String> fileNameList = new ArrayList<>();//�ļ����б�
        List<String> folderNameList = new ArrayList<>();//�ļ������б�
        File f = new File(folderPath);
        if (!f.exists()) { //·��������
            map.put("retType", "1");
        }else{
            boolean flag = f.isDirectory();
            if(flag==false){ //·��Ϊ�ļ�
                map.put("retType", "2");
                map.put("fileName", f.getName());
            }else{ //·��Ϊ�ļ���
                map.put("retType", "3");
                File fa[] = f.listFiles();
                queryStr = queryStr==null ? "" : queryStr;//��queryStr����Ϊnull,���滻Ϊ�գ�indexOfƥ��ֵ����Ϊnull��
                for (int i = 0; i < fa.length; i++) {
                    File fs = fa[i];
                    if(fs.getName().indexOf(queryStr)!=-1){
                        if (fs.isDirectory()) {
                            folderNameList.add(fs.getName());
                        } else {
                            fileNameList.add(fs.getName());
                        }
                    }
                }
                map.put("fileNameList", fileNameList);
                map.put("folderNameList", folderNameList);
            }
        }
        return map;
    }
    public static void main(String[] args) {
        new SelectAppLnkService(null);
    }
}
