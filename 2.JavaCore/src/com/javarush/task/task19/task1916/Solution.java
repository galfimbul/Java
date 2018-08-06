package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception{
        BufferedReader filename = new BufferedReader(new InputStreamReader(System.in));
        String name1 = filename.readLine();
        String name2 = filename.readLine();
        BufferedReader file1 = new BufferedReader(new FileReader(name1));
        BufferedReader file2 = new BufferedReader(new FileReader(name2));
        filename.close();

        //BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
        //BufferedReader file2 = new BufferedReader(new FileReader(args[1]));
        ArrayList<String> lines1 = new ArrayList<>();
        ArrayList<String> lines2 = new ArrayList<>();
        String a;
        while((a= file1.readLine())!=null){
            lines1.add(a);
        }
        while((a= file2.readLine())!=null){
            lines2.add(a);
        }
        file1.close();
        file2.close();
        /*System.out.println("Строки первого файла: ");
        for(String words:lines1){
            System.out.println(words);
        }
        System.out.println("Строки второго файла: ");
        for(String words:lines2){
            System.out.println(words);
        }
        System.out.println("----------------");*/
        int i=0;
        int j=0;

        for(i=0;i<lines1.size();){
            for(j=0;j<lines2.size();){
                if(i<lines1.size()&&j<lines2.size()&&lines1.get(i).equals(lines2.get(j))){
                    lines.add(new LineItem(Type.SAME,lines1.get(i)));
                    i++;
                    j++;
                }
                else
                if(i+1<lines1.size() && lines1.get(i+1).equals(lines2.get(j))){
                    lines.add(new LineItem(Type.REMOVED,lines1.get(i)));
                    i++;
                }
                else
                if(j+1<lines2.size() && lines1.get(i).equals(lines2.get(j+1))){
                    lines.add(new LineItem(Type.ADDED,lines2.get(j)));
                    j++;
                }
                else j++;


            }
            i++;

        }
        if(lines1.size()>lines2.size()&&i<=lines1.size()){
            lines.add(new LineItem(Type.REMOVED,lines1.get(i-1)));

        }
        else
        if(lines2.size()>lines1.size()&&j<=lines2.size()){
            lines.add(new LineItem(Type.ADDED,lines2.get(j)));
        }
        else
            if(lines2.size()<lines1.size()&&!lines1.get(lines1.size()-1).equals(lines2.get(lines2.size()-1)))
                lines.add(new LineItem(Type.ADDED,lines2.get(lines2.size()-1)));
        for(LineItem words:lines){
            System.out.println(words.type+" " +words.line);
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
