package com.cn.assistant.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * �������������������������ԭ�е��������ƥ��
 * ƥ�������󹫹��ַ���
 */
public class CommandMatchingUtils {
    private int a;
    private int b;

    public String getMaxLengthCommonString(String s1, String s2) {
        if (s1 == null || s2 == null)  {
            return null;
        }
        a = s1.length();//s1��������
        b = s2.length();//s2��������
        if(a== 0 || b == 0) {
            return "";
        }
        //����ƥ�����
        boolean [][] array = new boolean[a][b];
        for (int i = 0; i  < a; i++) {
            char c1 = s1.charAt(i);
            for (int j = 0; j < b; j++) {
                char c2 = s2.charAt(j);
                if (c1 == c2) {
                    array[i][j] = true;
                }  else {
                    array[i][j] = false;
                }
            }
        }
        //��ȫ���������ַ�����������ϢΪ��Եڶ����ַ�������ʼλ�úͳ���
        List<ChildString> childStrings = new ArrayList<ChildString>();
        for (int i = 0; i < a; i++) {
            getMaxSort(i, 0, array, childStrings);
        }
        for (int i = 1; i < b; i++) {
            getMaxSort(0, i, array, childStrings);
        }
        //����
        sort(childStrings);
        if (childStrings.size() < 1) {
            return "";
        }
        //������������ַ���
        int max = childStrings.get(0).maxLength;
        StringBuffer sb = new StringBuffer();
        for (ChildString s: childStrings) {
            if (max != s.maxLength) {
                break;
            }
            sb.append(s2.substring(s.maxStart, s.maxStart + s.maxLength));
            sb.append("\n");
        }
        return sb.toString();
    }

    //���򣬵���
    private void sort(List<ChildString> list) {
        Collections.sort(list, new Comparator<ChildString>(){
            @Override
            public int compare(ChildString o1, ChildString o2) {
                return o2.maxLength - o1.maxLength;
            }
        });
    }

    //��һ��б���ϵĹ������ַ���
    private void getMaxSort(int i, int j, boolean [][] array, List<ChildString> sortBean) {
        int length = 0;
        int start = j;
        for (; i < a && j < b; i++,j++) {
            if (array[i][j]) {
                length++;
            } else {
                sortBean.add(new ChildString(length, start));
                length = 0;
                start = j + 1;
            }
            if (i == a-1 || j == b-1) {
                sortBean.add(new ChildString(length, start));
            }
        }
    }

    //��������
    class ChildString {
        int maxLength;
        int maxStart;

        ChildString(int maxLength, int maxStart){
            this.maxLength = maxLength;
            this.maxStart = maxStart;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new CommandMatchingUtils().getMaxLengthCommonString("��������", "������"));
    }
}