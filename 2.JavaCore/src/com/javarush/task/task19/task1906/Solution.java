package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String inputFile = reader.readLine();
        String inputFile = "D:\\test.txt";
        //String outputFile = reader.readLine();
        String outputFile = "D:\\test2.txt";
        reader.close();
        FileReader input = new FileReader(inputFile);
        FileWriter output = new FileWriter(outputFile);
        int count = 1;
        while(input.ready()){
            int symbol = input.read();
            count ++;
            if(count%2==1){
                output.write(symbol);
            }
        }
        input.close();
        output.close();
    }
}
