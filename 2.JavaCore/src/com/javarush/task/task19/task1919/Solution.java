package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/





import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = args[0];
        MyThread myThread = new MyThread(fileName);
        Thread thread = new Thread(myThread);
        thread.start();
        thread.join();
        myThread.printMap();
    }


        /*TreeMap<String, Double> map = new TreeMap<String, Double>();
        FileReader fileReader = new FileReader(args[0]);

//        FileReader fileReader = new FileReader("/home/user/java_test/test");

        BufferedReader rd = new BufferedReader(fileReader);

        String[] symbols;
        String line;
        Double currentValue;

        while ((line = rd.readLine()) != null) {
//            line = rd.readLine();
            symbols = line.split(" ");
            System.out.println("0 элемент массива: "+ map.containsKey(symbols[0]));

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

        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }*/
    public static class MyThread implements Runnable{
        public MyThread(String args){
            this.fileName = args;
        }
        private String fileName;
        String line;

        Double value;
        TreeMap<String,Double> map = new TreeMap<>();
        public void printMap(){
            for(Map.Entry<String,Double> pairs: map.entrySet()){
                System.out.println(pairs.getKey() + " " + pairs.getValue());
            }
        }

        public void run() {

                try {
                    BufferedReader reader = new BufferedReader(new FileReader(fileName));
                    line = reader.readLine();
                    String[] mass;
                    while (line != null) {
                        mass = line.split(" ");
                        //System.out.println("0 элемент массива: " + map.containsKey(mass[0]));
                        if (map.containsKey(mass[0])) {
                            value = map.get(mass[0]);
                            map.put(mass[0], value + Double.parseDouble(mass[1]));
                        } else {
                            map.put(mass[0], Double.parseDouble(mass[1]));
                        }
                        line = reader.readLine();
                    }
                    reader.close();

                } catch (IOException e) {
                    e.getCause();
                }
        }
    }
    }

