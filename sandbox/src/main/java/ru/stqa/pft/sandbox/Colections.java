package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Colections {

  public static void main(String[] args) {

    String[] langs = new String[4];
    langs[0] = "Java";
    langs[1] = "C#";
    langs[2] = "Python";
    langs[3] =  "PHP";

   // String[] fruits = {"apple", "mango", "grappe"};


    List <String> languages = new ArrayList<String>();
    languages.add("Java");
    languages.add("C#");
    languages.add("C++");

    List<String> fruits = Arrays.asList("apple", "mango", "grappe");


    for (int i = 1;  i < langs.length; i ++) {
      System.out.println("Program languages "+langs[i]);
    }

    for (String l : fruits) {
      System.out.println("I want to eat "+l);
    }

    for (int i =1; i < fruits.size(); i++){
      System.out.println("I love "+fruits.get(i));
    }

  }
}
