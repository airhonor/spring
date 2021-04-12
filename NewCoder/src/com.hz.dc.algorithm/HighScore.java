package com.hz.newcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
*@author zgr
*@date 2020年11月22日 下午2:47:46
*@version 0.1
**/

/**
 * 老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩.
 * 输入描述:
 * 输入包括多组测试数据。
 * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 * 学生ID编号从1编到N。
 * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 *
 * 输出描述:
 * 对于每一次询问操作，在一行里面输出最高成绩.
 *
 * 输入例子1:
 * 5 7
 * 1 2 3 4 5
 * Q 1 5
 * U 3 6
 * Q 3 4
 * Q 4 5
 * U 4 5
 * U 2 9
 * Q 1 5
 *
 * 输出例子1:
 * 5
 * 6
 * 5
 * 9
 */
public class HighScore {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int studentNum = in.nextInt();
			int doNum = in.nextInt();
			int[] initScore = new int[studentNum];
			for(int i=0; i<studentNum; i++) {
				initScore[i] = in.nextInt();
			}
			in.nextLine();
			for(int i=0; in.hasNext() && i< doNum; i++){
			
				String[] str = in.nextLine().split(" ");
				int str1 = Math.min(Integer.parseInt(str[1]), Integer.parseInt(str[2]));
				int str2 = Math.max(Integer.parseInt(str[1]), Integer.parseInt(str[2]));
				if(str[0].equals("U")) {
					initScore[Integer.parseInt(str[1]) - 1] = Integer.parseInt(str[2]);
				}else {
					int[] temp = new int[str2 - str1 + 1];
					System.arraycopy(initScore, str1-1, temp, 0, temp.length);
					Arrays.sort(temp);
					System.out.println(temp[temp.length - 1]);
				}
			}
		}
	}

}
