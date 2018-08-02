package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static{
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader input = new BufferedReader(new FileReader(fileName));
        //BufferedReader input = new BufferedReader(new FileReader("D:\\test.txt"));
        String line;
        String[] mass;
        StringBuilder string = new StringBuilder();
        while((line = input.readLine())!=null){
            mass = line.split(" ");
            for(Map.Entry<Integer, String> word:map.entrySet()){
                for(int i = 0; i< mass.length; i++){
                    if(word.getKey().toString().equals(mass[i])){
                        mass[i] = word.getValue();
                    }
                }
            }
            for(String mas:mass){
                string.append(mas).append(" ");
            }

            System.out.println(string.toString().trim());
            string.delete(0,string.length());
        }
        input.close();


    }
}
