package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line;
        String[] mass;
        SimpleDateFormat df = new SimpleDateFormat("dd MM yyyy");
        while ((line= reader.readLine())!=null){
            mass = line.split("\\w");
            String name = mass[0].trim();
            mass = line.split("\\W*",2);
            String date = mass[1];
            PEOPLE.add(new Person(name,df.parse(date)));
            //System.out.println("-----------");
            //System.out.println(name);
            //System.out.println(date);


        }
        reader.close();
        /*for(Person list:PEOPLE){
            System.out.println(list.getName());
            System.out.println("-----");
            System.out.println(list.getBirthday());
        }*/

    }
}
