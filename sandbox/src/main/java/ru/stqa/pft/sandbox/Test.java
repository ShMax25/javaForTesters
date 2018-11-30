package ru.stqa.pft.sandbox;

import java.util.Scanner;

public class Test {

//  public static void main (String[] args){
//
//    String J = "aA";
//    String S ="aAAbbbb";
//
//    for (int i = 0; i == J.length(); i++){
//      String jewel = J[i];
//
//    }
//  }


//  public static void main(String[] args){ // 1 2 3 4 5
//    for (int i = 1; i <= 5; i++) {
//      System.out.print(i + " ");
//    }
//  }

//  public static void main(String[] args){ // 5 4 3 2 1
//    for (int i = 5; i >= 1; i--) {
//      System.out.print(i + " ");
//    }
//  }
//  public static void main(String[] args){
//    for (int a =1; a<=10; a++){
//      int b = 3 * a;
//      System.out.println("3*"+a+"="+b);
//    }
//  }

//  public static void main(String[] args){
//    Scanner sc = new Scanner(System.in);
//    int num = sc.nextInt();
//    int res = 0;
//    for (int i = 1; i <= num; i++){
//      res += i;
//    }
//    System.out.println(res);
//  }
  public static void main(String[] args){
   String one = zadanie("game");
   String two = zadanie("yy");
   String three = zadanie("a");
    System.out.println(one);
    System.out.println(two);
    System.out.println(three);
  }

  public static String zadanie (String str) {
    int len = str.length();
    if (len >= 2) {
      return str.substring(0,2);
    } else if (len == 1){
      return str.charAt(0)+"@";
    } else {
      return "@@";
    }
  }
}





