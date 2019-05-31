package com.cn.assistant.entity;

import com.cn.assistant.service.SelectAppLnkService;

import java.util.*;

/**
 * 这个类用来获取桌面的所有快捷方式,文件和文件夹，并将其放到数组appLINKS中
 */
public class DesktopAppLNK {
    public static String [] appLNKS;
    public static String [] apps;
    public static String [] folders;
    public static String [] files;
    public  List<String> folderNameList1;
    public  List<String> fileNameList1;

    public DesktopAppLNK() {
        GetDeskLINKS();
        GetApps();
        GetDeskFolders();
        GetDeskFiles();

    }
    //获取桌面上的快捷方式
    public void GetDeskLINKS(){
        HashMap<String, Object> lnkMap = new HashMap<String, Object>();
        lnkMap = new SelectAppLnkService(".lnk").filesName;
        Set<String> strings = lnkMap.keySet();

        if (strings.contains("fileNameList")) {
            fileNameList1 = (List<String>) lnkMap.get("fileNameList");
        }
        appLNKS = new String[fileNameList1.size()];
        fileNameList1.toArray(appLNKS);
//        这是测试
//        for (String  s: appFiles){
//            System.out.println(s);
//        }
    }
    //获取煮面上的EXE文件
    public void GetApps(){
        HashMap<String, Object> exeMap = new HashMap<String, Object>();
        exeMap = new SelectAppLnkService("exe").filesName;
        Set<String> strings = exeMap.keySet();

        if (strings.contains("fileNameList")) {
            fileNameList1 = (List<String>) exeMap.get("fileNameList");
        }
        apps = new String[fileNameList1.size()];
        //list转数组
        fileNameList1.toArray(apps);
        //去除带exe的lnk文件
        apps = arrContrast(apps,appLNKS);
//        这是测试
//        for (String  s: appFiles){
//            System.out.println(s);
//        }
    }
    //获取桌面上的文件夹
    public void GetDeskFolders(){
        HashMap<String, Object> folderMap = new HashMap<String, Object>();
        folderMap = new SelectAppLnkService(null).filesName;
        Set<String> strings = folderMap.keySet();

        if (strings.contains("folderNameList")) {
            folderNameList1 = (List<String>) folderMap.get("folderNameList");
        }
        folders = new String[folderNameList1.size()];
        //list转数组
        folderNameList1.toArray(folders);
//        这是测试
//        for (String  s: folders){
//            System.out.println(s);
//        }
    }
    //获取桌面上的文件
    public void GetDeskFiles(){
        HashMap<String, Object> fileMap = new HashMap<String, Object>();

        HashMap<String, Object> docMap = new HashMap<String, Object>();
        docMap = new SelectAppLnkService(".doc").filesName;
        Set<String> doc = docMap.keySet();
        if (doc.contains("fileNameList")) {
            fileNameList1 = (List<String>) (docMap.get("fileNameList"));
        }

        HashMap<String, Object> txtMap = new HashMap<String, Object>();
        txtMap = new SelectAppLnkService(".txt").filesName;
        Set<String> txt = txtMap.keySet();
        if (txt.contains("fileNameList")) {
            fileNameList1.addAll((List<String>) (txtMap.get("fileNameList")));
        }

        HashMap<String, Object> pdfMap = new HashMap<String, Object>();
        pdfMap = new SelectAppLnkService(".pdf").filesName;
        Set<String> pdf = pdfMap.keySet();
        if (pdf.contains("fileNameList")) {
            fileNameList1.addAll((List<String>) (pdfMap.get("fileNameList")));
        }

        HashMap<String, Object> zipMap = new HashMap<String, Object>();
        zipMap = new SelectAppLnkService(".zip").filesName;
        Set<String> zip = zipMap.keySet();
        if (zip.contains("fileNameList")) {
            fileNameList1.addAll((List<String>) (zipMap.get("fileNameList")));
        }
        System.out.println(fileNameList1.size());
        files = new String[fileNameList1.size()];
        //list转数组
        fileNameList1.toArray(files);
        //去除lnk文件
        files = arrContrast(files,appLNKS);
//        这是测试
        for (String  s: files){
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
        new DesktopAppLNK();


    }

    /**
     * 移除两个数组中重复的部分
     * @param arr1
     * 要保留的数组
     * @param arr2
     * 校验数组
     * @return
     */
    private static String[] arrContrast(String[] arr1, String[] arr2){
        List<String> list = new LinkedList<String>();

        //处理第一个数组,list里面的值为1,2,3,4
        for (String str : arr1) {
            if (!list.contains(str)) {
                list.add(str);
            }
        }
        //如果第二个数组存在和第一个数组相同的值，就删除
        for (String str : arr2) {
            if(list.contains(str)){
                list.remove(str);
            }
        }
        //创建空数组
        String[] result = {};
        //List to Array
        return list.toArray(result);
    }
    /**
     * 复制map对象
     * @explain 将paramsMap中的键值对全部拷贝到resultMap中；
     * paramsMap中的内容不会影响到resultMap（深拷贝）
     * @param paramsMap
     *     被拷贝对象
     * @param resultMap
     *     拷贝后的对象
     */
    public static void mapCopy(Map paramsMap, Map resultMap) {
        if (resultMap == null) {
            resultMap = new HashMap();
        }
        if (paramsMap == null) {
            return;
        }

        Iterator it = paramsMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            resultMap.put(key, paramsMap.get(key) != null ? paramsMap.get(key) : "");

        }
    }

}

