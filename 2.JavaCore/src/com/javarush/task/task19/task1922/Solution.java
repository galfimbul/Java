package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception{
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(console.readLine()));
        //BufferedReader file = new BufferedReader(new FileReader("D:/test.txt"));
        console.close();
        String line;
        int count = 0;
        String[]mass;
        while((line = file.readLine())!=null){
            mass = line.split(" ");
            for(String word:words){
                for(String lines:mass){
                    if (lines.equals(word)) {
                        count++;
                    }
                }
            }
            if(count==2){
                System.out.println(line);
            }
            count=0;
        }
        file.close();

    }
}
