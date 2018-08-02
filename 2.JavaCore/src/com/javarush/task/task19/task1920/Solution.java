package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception{
        TreeMap<String, Double> map = new TreeMap<String, Double>();
        FileReader fileReader = new FileReader(args[0]);

//        FileReader fileReader = new FileReader("/home/user/java_test/test");

        BufferedReader rd = new BufferedReader(fileReader);

        String[] symbols;
        String line;
        Double currentValue;

        while ((line = rd.readLine()) != null) {
//            line = rd.readLine();
            symbols = line.split(" ");
            //System.out.println("0 элемент массива: "+ map.containsKey(symbols[0]));

            if (map.containsKey(symbols[0]))
            {
                currentValue = map.get(symbols[0]);
                map.put(symbols[0], Double.parseDouble(symbols[1]) + currentValue);
            } else {
                map.put(symbols[0], Double.parseDouble(symbols[1]));
            }
        }

        rd.close();
        fileReader.close();
        Double count = 0d;
        //Double max = 0d;
        for(Map.Entry<String,Double> pairs:map.entrySet()){
            if(pairs.getValue()>count){
                count = pairs.getValue();
            }

        }
        for(Map.Entry<String,Double> pairs:map.entrySet()){
            if(pairs.getValue().equals(count)){
                System.out.println(pairs.getKey());
            }

        }

    }
}
