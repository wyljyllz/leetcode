package main;

import wei.sort.basic.Select;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
       Integer[] arry = {1,3,2,9,7,6};
        Select<Integer> select = new Select<>();
        select.sort(arry);
        System.out.println(Arrays.toString(arry));

    }
}
