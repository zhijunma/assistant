package com.cn.assistant.entity;

import com.cn.assistant.service.SelectAppLnkService;

import java.util.*;

/**
 * �����������ȡ��������п�ݷ�ʽ,�ļ����ļ��У�������ŵ�����appLINKS��
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
    //��ȡ�����ϵĿ�ݷ�ʽ
    public void GetDeskLINKS(){
        HashMap<String, Object> lnkMap = new HashMap<String, Object>();
        lnkMap = new SelectAppLnkService(".lnk").filesName;
        Set<String> strings = lnkMap.keySet();

        if (strings.contains("fileNameList")) {
            fileNameList1 = (List<String>) lnkMap.get("fileNameList");
        }
        appLNKS = new String[fileNameList1.size()];
        fileNameList1.toArray(appLNKS);
//        ���ǲ���
//        for (String  s: appFiles){
//            System.out.println(s);
//        }
    }
    //��ȡ�����ϵ�EXE�ļ�
    public void GetApps(){
        HashMap<String, Object> exeMap = new HashMap<String, Object>();
        exeMap = new SelectAppLnkService("exe").filesName;
        Set<String> strings = exeMap.keySet();

        if (strings.contains("fileNameList")) {
            fileNameList1 = (List<String>) exeMap.get("fileNameList");
        }
        apps = new String[fileNameList1.size()];
        //listת����
        fileNameList1.toArray(apps);
        //ȥ����exe��lnk�ļ�
        apps = arrContrast(apps,appLNKS);
//        ���ǲ���
//        for (String  s: appFiles){
//            System.out.println(s);
//        }
    }
    //��ȡ�����ϵ��ļ���
    public void GetDeskFolders(){
        HashMap<String, Object> folderMap = new HashMap<String, Object>();
        folderMap = new SelectAppLnkService(null).filesName;
        Set<String> strings = folderMap.keySet();

        if (strings.contains("folderNameList")) {
            folderNameList1 = (List<String>) folderMap.get("folderNameList");
        }
        folders = new String[folderNameList1.size()];
        //listת����
        folderNameList1.toArray(folders);
//        ���ǲ���
//        for (String  s: folders){
//            System.out.println(s);
//        }
    }
    //��ȡ�����ϵ��ļ�
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
        //listת����
        fileNameList1.toArray(files);
        //ȥ��lnk�ļ�
        files = arrContrast(files,appLNKS);
//        ���ǲ���
        for (String  s: files){
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
        new DesktopAppLNK();


    }

    /**
     * �Ƴ������������ظ��Ĳ���
     * @param arr1
     * Ҫ����������
     * @param arr2
     * У������
     * @return
     */
    private static String[] arrContrast(String[] arr1, String[] arr2){
        List<String> list = new LinkedList<String>();

        //�����һ������,list�����ֵΪ1,2,3,4
        for (String str : arr1) {
            if (!list.contains(str)) {
                list.add(str);
            }
        }
        //����ڶ���������ں͵�һ��������ͬ��ֵ����ɾ��
        for (String str : arr2) {
            if(list.contains(str)){
                list.remove(str);
            }
        }
        //����������
        String[] result = {};
        //List to Array
        return list.toArray(result);
    }
    /**
     * ����map����
     * @explain ��paramsMap�еļ�ֵ��ȫ��������resultMap�У�
     * paramsMap�е����ݲ���Ӱ�쵽resultMap�������
     * @param paramsMap
     *     ����������
     * @param resultMap
     *     ������Ķ���
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

