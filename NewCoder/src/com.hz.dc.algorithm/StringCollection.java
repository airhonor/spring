package com.hz.dc.algorithm;

/**
 * @program: NewCoder
 * @author: zgr
 * @create: 2020-11-24 22:20
 **/

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 输入一个字符串，求出该字符串包含的字符集合
 *
 * 输入描述:
 * 每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。
 *
 * 输出描述:
 * 每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。
 *
 * 输入例子1:
 * abcqweracb
 *
 * 输出例子1:
 * abcqwer
 */
public class StringCollection {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            int len = str.length();
            Set<String> set = new LinkedHashSet<>();
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<len; i++){
                set.add(str.substring(i, i+1));
            }
            set.forEach(sb::append);
            System.out.println(sb.toString());
        }
        in.close();
    }
}
