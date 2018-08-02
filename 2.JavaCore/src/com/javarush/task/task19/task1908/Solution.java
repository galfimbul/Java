package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputFile = reader.readLine();
        //String inputFile = "D:/test.txt";
        String outputFile = reader.readLine();
        //String outputFile = "D:/test2.txt";
        reader.close();
        BufferedReader inputReader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter outputWriter = new BufferedWriter(new FileWriter(outputFile));
        String line = inputReader.readLine();
        String[] mass = null;
        while (line != null) {
            mass = line.split(" ");
            for (String digit : mass) {
                System.out.println(digit);
                if (digit.matches("\\d+")){
                    outputWriter.write(digit + " ");
                    //outputWriter.write(" ");
                }
            }
            //line = line.replaceAll("[\\D]","");

            line = inputReader.readLine();
        }
        inputReader.close();
        outputWriter.close();
    }
}


