package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) throws Exception{
        String input = args[0];
        String output = args[1];
        BufferedReader inputFile = new BufferedReader(new FileReader(input));
        BufferedWriter outputFile = new BufferedWriter(new FileWriter(output));
        String line;
        String[] mass;
        while((line = inputFile.readLine())!=null){
            mass = line.split(" ");
            for(String word:mass) {
                if (word.matches(".*\\d.*"))
                    outputFile.write(word + " ");
            }

        }
        outputFile.close();
        inputFile.close();
    }
}
