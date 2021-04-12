package com.hz.newcoder;

/**
 * @program: NewCoder
 * @author: zgr
 * @create: 2020-11-22 16:28
 **/

import java.util.*;

/**
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 * 处理:
 * 1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
 * 2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
 * 3.输入的文件可能带路径，记录文件名称不能带路径
 *
 * 输入描述:
 * 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 *
 *     文件路径为windows格式
 *
 *     如：E:\V1R2\product\fpgadrive.c 1325
 *
 * 输出描述:
 * 将所有的记录统计并将结果输出，格式：文件名代码行数数目，一个空格隔开，如: fpgadrive.c 1325 1
 *
 *     结果根据数目从多到少排序，数目相同的情况下，按照输入第一次出现顺序排序。
 *
 *     如果超过8条记录，则只输出前8条记录.
 *
 *     如果文件名的长度超过16个字符，则只输出后16个字符
 *
 * 输入例子1:
 * E:\V1R2\product\fpgadrive.c 1325
 *
 * 输出例子1:
 * fpgadrive.c 1325 1
 */
public class ErrorRecorder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> temp = new LinkedHashMap<>();
        while (in.hasNext()) {
            String[] str = in.nextLine().split(" ");
            int rowNum = Integer.parseInt(str[1]);
            int fileIndex = str[0].lastIndexOf('\\');
            String fileName = fileIndex < 0? str[0]: str[0].substring(fileIndex + 1);
            String tempRecorder = fileName + " " + rowNum;
            if (temp.containsKey(tempRecorder)){
                temp.put(tempRecorder, temp.get(tempRecorder) + 1);
            }else {
                temp.put(tempRecorder, 1);
            }
         }
        in.close();

        List<Map.Entry<String, Integer>> list = new LinkedList<>(temp.entrySet());
        list.sort((o1, o2) -> (o1.getValue() - o2.getValue() == 0) ? (o1.getValue() - o2.getValue()) : (o2.getValue() - o1.getValue()));

        int m=0;
        for(Map.Entry<String, Integer> mapping : list){
            m++;
            if(m<=8){
                String[] str = mapping.getKey().split(" ");
                String k = str[0].length()>16 ? str[0].substring(str[0].length()-16) : str[0];
                String n = str[1];
                System.out.println(k+" "+n+" "+mapping.getValue());
            }else{
                break;
            }

        }
    }
}
