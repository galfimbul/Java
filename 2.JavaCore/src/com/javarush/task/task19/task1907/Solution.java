package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //String filename = reader.readLine();
        reader.close();
        String filename = "D:/test.txt";
        FileReader input = new FileReader(filename);
        BufferedReader rd = new BufferedReader(input);
        String line = rd.readLine();
        int count = 0;
        while(line !=null) {
            String [] parts = line.split(" ");
            //for( String w : parts)
            //{
              //  System.out.println(w);
            //}
            for( int i =0; i< parts.length; i++)
            {
                parts[i] = parts[i].replaceAll("\\W*","");
            }

            for( String w : parts)
            {
                if(w.equals("world")){
                    count++;
                }
            }
            line = rd.readLine();
        }
        input.close();
        rd.close();
        System.out.println(count);
    }
}
