package com.cn.assistant.entity;

import com.cn.assistant.service.SelectAppLnkService;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class DesktopAppLNK {
    public  String [] appLNKS;
    public  List<String> folderNameList1;

    public DesktopAppLNK() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map = new SelectAppLnkService(null).filesName;
        Set<String> strings = map.keySet();
        HashMap<String, Object> finalMap = map;

        if (strings.contains("fileNameList")) {
            folderNameList1 = (List<String>) finalMap.get("fileNameList");
//            folderNameList1.forEach(System.out::println);
//            System.out.println(folderNameList1.size());
        }
        appLNKS = new String[folderNameList1.size()];
        folderNameList1.toArray(appLNKS);

    }

    public static void main(String[] args) {
        new DesktopAppLNK();
        System.out.println(new DesktopAppLNK().appLNKS[1]);
    }
}

