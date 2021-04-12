package com.hz.dc.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: NewCoder
 * @author: zgr
 * @create: 2020-11-22 20:48
 **/
public class PokerGame {
    public static void main(String[] args) {
        String firstSingle = "JOKER";
        String secondSingle = "joker";

        Map<String, Integer> orderMap = new HashMap<>();
        orderMap.put("3", 0);
        orderMap.put("4", 1);
        orderMap.put("5", 2);
        orderMap.put("6", 3);
        orderMap.put("7", 4);
        orderMap.put("8", 5);
        orderMap.put("9", 6);
        orderMap.put("10", 7);
        orderMap.put("J", 8);
        orderMap.put("Q", 9);
        orderMap.put("K", 10);
        orderMap.put("A", 11);
        orderMap.put("2", 12);
        orderMap.put(secondSingle, 13);
        orderMap.put(firstSingle, 14);
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
          String[] pokers =  in.nextLine().split("-");
            String[] poker1 = pokers[0].split(" ");
            String[] poker2 = pokers[1].split(" ");
          if (poker1.length == 1){
              //单牌
              if (poker2.length == 4){
                  printPoker(poker2);
              }else if (poker2.length == 2 && ((poker2[0].equals(firstSingle) && poker2[1].equals(secondSingle)) || (poker2[1].equals(firstSingle)
                      && poker2[0].equals(secondSingle)))){
                  printPoker(poker2);
              }else if(poker2.length == 1){
                  printPoker(orderMap.get(poker1[0]) > orderMap.get(poker2[0])? poker1: poker2);
              }else {
                  System.out.println("ERROR");
              }
              break;
          }else if (poker1.length == 2){
              //双王
              if((poker1[0].equals(firstSingle) && poker1[1].equals(secondSingle)) || (poker1[1].equals(firstSingle)
                      && poker1[0].equals(secondSingle))){
                  printPoker(poker1);
                  break;
              }
              //对子
              else {
                  if (poker2.length == 4) {
                      printPoker(poker2);
                  } else if (poker2.length == 2) {
                      if ((poker2[0].equals(firstSingle) && poker2[1].equals(secondSingle)) || (poker2[1].equals(firstSingle)
                              && poker2[0].equals(secondSingle))) {
                          printPoker(poker2);
                      } else {
                          printPoker(orderMap.get(poker1[0]) > orderMap.get(poker2[0]) ? poker1 : poker2);
                      }
                  } else {
                      System.out.println("ERROR");
                  }

                  break;
              }
          }else if (poker1.length == 3){
              //三张
              if (poker2.length == 4){
                  printPoker(poker2);
              }else if (poker2.length == 2 && ((poker2[0].equals(firstSingle) && poker2[1].equals(secondSingle)) || (poker2[1].equals(firstSingle)
                      && poker2[0].equals(secondSingle)))){
                  printPoker(poker2);
              }else if(poker2.length == 3){
                  printPoker(orderMap.get(poker1[0]) > orderMap.get(poker2[0])? poker1: poker2);
              }else {
                  System.out.println("ERROR");
              }
              break;
          }else if (poker1.length == 4){
              //4个的炸弹
              if (poker2.length == 4){
                  printPoker(orderMap.get(poker1[0]) > orderMap.get(poker2[0])? poker1: poker2);
              }else if(poker2.length == 2 && ((poker2[0].equals(firstSingle) && poker2[1].equals(secondSingle)) || (poker2[1].equals(firstSingle)
                      && poker2[0].equals(secondSingle)))){
                  printPoker(poker2);
              }else {
                  printPoker(poker1);
              }
          }else {
            //顺子
              if (poker2.length == 4){
                  printPoker(orderMap.get(poker1[0]) > orderMap.get(poker2[0])? poker1: poker2);
              }else if(poker2.length == 2 && ((poker2[0].equals(firstSingle) && poker2[1].equals(secondSingle)) || (poker2[1].equals(firstSingle)
                      && poker2[0].equals(secondSingle)))){
                  printPoker(poker2);
              }else if (poker2.length == 5){
                  printPoker(orderMap.get(poker1[0]) > orderMap.get(poker2[0])? poker1: poker2);
              }else {
                  System.out.println("ERROR");
              }
              break;
          }
        }
        in.close();
    }

    private static void printPoker(String[] poker){
        if (poker.length == 1){
            System.out.println(poker[0]);
        }else {
            for (int i=0; i<poker.length - 1; i++){
                System.out.print(poker[i] + " ");
            }
            System.out.println(poker[poker.length - 1]);
        }
    }
}
