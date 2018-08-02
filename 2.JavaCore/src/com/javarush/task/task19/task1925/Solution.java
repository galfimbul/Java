package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new FileReader(args[0]));
        BufferedWriter output = new BufferedWriter(new FileWriter(args[1]));
        StringBuilder lines = new StringBuilder();
        String[] mass;
        String line;
        while ((line = input.readLine())!= null){
            mass = line.split(" ");
            for(String word:mass){
                if(word.length()>6){
                    lines.append(word + ",");
                }
            }

        }
        input.close();
        //System.out.println(lines.deleteCharAt(lines.length()-1).toString());
        output.write(lines.deleteCharAt(lines.length()-1).toString());
        output.close();

    }
}
