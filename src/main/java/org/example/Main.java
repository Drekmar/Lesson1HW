package org.example;

import java.util.*;
/**
 *This is my main class, here i will launch my code
 * */



public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        Integer[] mass={17, 14, 15, 28, 6, 8, -6, 1, 3, 18};
        Integer[] mass2={17, 2312, 111, 0, 0, 8, -6, 1, 3, 18,1,1,1,1,1};

        ArrayList aralist=new ArrayList<>();
        Collections.addAll(aralist,mass);
        System.out.println(aralist);


        List a1 = new Arrlist(mass);
        Arrlist a2 =new Arrlist();
        Arrlist a3 = new Arrlist();
        a3.addAll(mass2);
        Collections.addAll(a1,mass2);
        Collections.addAll(a2,mass);

        System.out.println(a1+"1");
        System.out.println(a2+"2");
        System.out.println(a3+"3");

        Comparator<Integer> comparator = Integer::compareTo;


        Comparator<Integer> comparator2 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };


        SomeQSort.qSort(aralist, comparator);
        System.out.println(aralist);

             SomeQSort.qSort(a1, comparator);
             SomeQSort.qSort(a2,comparator);
             SomeQSort.qSort(a3,comparator);
      System.out.println(a2);
        System.out.println(a1);
        System.out.println(a3);
    }
}