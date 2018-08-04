package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        //String fileName = args[0];
        BufferedReader input = new BufferedReader(new FileReader(fileName));
        String line;
        StringBuilder stroka = new StringBuilder();
        while ((line = input.readLine())!=null){
            stroka.append(line);
            System.out.println(stroka.reverse());
            stroka.delete(0,stroka.length());
        }
        input.close();
    }
}
