package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String inputFile ="D:/test.txt";
        //String outputFile="D:/test2.txt";
        String inputFile = reader.readLine();
        String outputFile = reader.readLine();
        BufferedReader frd = new BufferedReader(new FileReader(inputFile));
        BufferedWriter fwr = new BufferedWriter(new FileWriter(outputFile));
        String line = frd.readLine();
        while(line !=null){
            line = line.replaceAll("\\p{Punct}","");
            fwr.write(line);
            line = frd.readLine();
        }
        reader.close();
        frd.close();
        fwr.close();
    }
}
